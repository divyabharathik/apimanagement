package com.example.troubleshootingtool.config;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


@Configuration
public class ElasticSearchConfigurationClass extends AbstractFactoryBean<RestHighLevelClient> {
    @Autowired
    private Environment env;

    private static final Logger LOG = LoggerFactory.getLogger(ElasticSearchConfigurationClass.class);

    @Value("${spring.data.elasticsearch.cluster-nodes}")
    private String clusterNodes;
    @Value("${spring.data.elasticsearch.cluster-name}")
    private String clusterName;

//    @Value("${elasticsearch.host}")
//    private String elasticsearchHost;
//    @Value("${elasticsearch.port}")
//    private int elasticsearchPort;

    private RestHighLevelClient restHighLevelClient;


    @Override
    public void destroy() {
        try {
            if (restHighLevelClient != null) {
                restHighLevelClient.close();
            }
        } catch (final Exception e) {
            LOG.error("Error closing ElasticSearch client: ", e);
        }
    }

    @Override
    public Class<RestHighLevelClient> getObjectType() {
        return RestHighLevelClient.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public RestHighLevelClient createInstance() {
        return buildClient();
    }

    private RestHighLevelClient buildClient() {
        try {
//            System.out.println("ELASTICSEARCH_HOST-"+env.getProperty("ElasticsearchHost"));
            String elasticsearchHost = System.getenv("ElasticsearchHost");
            int elasticsearchPort = Integer.parseInt(System.getenv("ElasticsearchPort"));
            System.out.println("Elasticsearch host:"+System.getenv("ElasticsearchHost")+" port:"+elasticsearchPort);
//            System.out.println("ELASTICSEARCH_HOST2-"+System.getenv("DOCKER_HOST"));
//            Map<String, String> envs = System.getenv();
//            for (String env :
//                    envs.keySet()) {
//                System.out.format("%s=%s%n",env,envs.get(env));
//            }
            restHighLevelClient = new RestHighLevelClient(
                    RestClient.builder( new HttpHost(elasticsearchHost,elasticsearchPort))
//                            new HttpHost("10.60.37.26", 9200, "http"),
//                            new HttpHost("10.60.37.26", 9201, "http"))
//                           new HttpHost("127.0.0.1", 9200, "http"),
//                           new HttpHost("127.0.0.1", 9201, "http"))
                            .setRequestConfigCallback(
                                    new RestClientBuilder.RequestConfigCallback() {
                                        @Override
                                        public RequestConfig.Builder customizeRequestConfig(
                                                RequestConfig.Builder requestConfigBuilder) {
                                            return requestConfigBuilder
                                                    .setConnectTimeout(5000)
                                                    .setSocketTimeout(60000);
                                        }
                                    }));

        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return restHighLevelClient;
    }

}
