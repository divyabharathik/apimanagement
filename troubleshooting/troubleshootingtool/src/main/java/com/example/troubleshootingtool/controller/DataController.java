package com.example.troubleshootingtool.controller;

import com.example.troubleshootingtool.bean.*;
import com.example.troubleshootingtool.dao.DataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class DataController {

    @Autowired
    private DataDao dataDao;


    public DataController(DataDao dataDao) {
        this.dataDao = dataDao;
    }

    @GetMapping("/error")
    public String error() {
        return "index.html";
    }

    //    @GetMapping("/all")
    @GetMapping("/qnas")
    public List<QAEntry> readAll() {
        return dataDao.getAllQAEntry("approved");
    }

    //    @PostMapping("/insertQandA")
    @PostMapping("/qnas")
    public String insertDataModel(@RequestBody QAEntry qandA) {
        return dataDao.insertQAEntry(qandA);
    }

    //    @RequestMapping(value = "/get_qa/{id}", method = RequestMethod.GET)
    @RequestMapping(value = "/qnas/{id}", method = RequestMethod.GET)
    public QAEntry getQandA(@PathVariable("id") String id) throws IOException {
        return dataDao.getQAEntryById(id, "approved");
    }

    //    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @RequestMapping(value = "/qnas/{id}", method = RequestMethod.PUT)
    public QAEntry updateQandA(@PathVariable("id") String id, @RequestBody QAEntry qandA) throws IOException {
        return dataDao.updateQAEntryById(id, qandA);
    }

    @RequestMapping(value = "/qnas/answer", method = RequestMethod.PUT)
    public QAEntry postAnswer(@RequestBody QAEntry qandA) throws IOException {
        return dataDao.postAnswer(qandA);
    }

    //    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @RequestMapping(value = "/qnas/{id}", method = RequestMethod.DELETE)
    public String deleteQandA(@PathVariable("id") String id) throws IOException {
        return dataDao.deleteQAEntryById(id);
    }

//    @GetMapping("/categories")
//    public List<String> getCategories() throws IOException {
//        return dataDao.getAdminCategories();
//    }

    @GetMapping("/tags")
    public List<String> getAllTags() throws IOException {
        return dataDao.getAllTags();
    }

    @RequestMapping(value = "/categories/{cat}/{from}/{size}", method = RequestMethod.GET)
    public List<QAEntry> getQandAforCategory(@PathVariable("cat") String category, @PathVariable("from") int from, @PathVariable("size") int size) throws IOException {
        return dataDao.getQAEntryforCategory(category, from, size);
    }


    @RequestMapping(value = "/search/{from}/{size}", method = RequestMethod.POST)
    public List<QAEntry> searchQuestion(@RequestBody SearchQuery searchQuery, @PathVariable("from") int from, @PathVariable("size") int size) throws IOException {
        return dataDao.searchQuery(searchQuery, from, size);
    }

    @RequestMapping(value = "/restore", method = RequestMethod.POST)
    public String restoreValues(@RequestBody List<QAEntry> qaEntryList) {
        return dataDao.restore(qaEntryList);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestBody ImageModel file) {
        System.out.println("File :" + file);
        return dataDao.uploadFiles(file);
    }

    @RequestMapping(value = "/files/{id}", method = RequestMethod.GET)
    public ArrayList<ImageModel> getFiles(@PathVariable("id") String id) throws IOException {
        return dataDao.getFilesById(id);
    }

//

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public User authenticate(@RequestBody User user, HttpServletRequest request) throws NullPointerException, IOException, NamingException {
        return dataDao.authenticate(user, request);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Boolean logout() throws NullPointerException {
        return dataDao.logout();
    }

    @RequestMapping(value = "/approve/{id}", method = RequestMethod.POST)
    public String approveQandA(@PathVariable("id") String id, @RequestBody QAEntry qandA) throws IOException {
        return dataDao.approveQnA(id, qandA);
    }

    @RequestMapping(value = "/approve/reject/{id}", method = RequestMethod.DELETE)
    public String rejectQandA(@PathVariable("id") String id) throws IOException {
        return dataDao.rejectQnA(id);
    }

    @GetMapping("/review")
    public List<QAEntry> readAllReviewQAEntry() {
        return dataDao.getAllQAEntry("review");
    }

    @GetMapping("/review/{id}")
    public QAEntry readAllReviewQAEntry(@PathVariable("id") String id) throws IOException {
        return dataDao.getQAEntryById(id, "review");
    }

    @PostMapping("/admin/add")
    public String insertAdmin(@RequestBody Admin admin) {
        System.out.println(admin.getUsername());
        return dataDao.insertAdmin(admin);
    }

    @GetMapping("/admin/get")
    public List<String> getAdmin() throws IOException {
        return dataDao.getAdmin();
    }

    @GetMapping("/repo")
    public String createRepo() throws IOException {
        return dataDao.createRepo();
    }
    @GetMapping("/snapshot/create")
    public String CreateSnapshot() throws IOException {
        return dataDao.CreateSnapshot();
    }
    @GetMapping("/snapshot/get")
    public String getSnapshot() throws IOException {
        return dataDao.getSnapshot();
    }
    @PostMapping("/snapshot/restore")
    public String restoreSnapshot() throws IOException {
        return dataDao.restoreSnapshot();
    }
    @PostMapping("/categories/add")
    public String addCategory(@RequestBody Categories admin_category ) throws IOException {
        return dataDao.addCategory(admin_category);
    }

    @GetMapping("/categories/get")
    public List<String> getCategory() throws IOException {
        return dataDao.getAdminCategories();
    }

    @RequestMapping(value = "/categories/delete/{item}", method = RequestMethod.DELETE)
    public String deleteCategory(@PathVariable("item") String item) throws IOException {
        return dataDao.deleteCategory(item);
    }

    @PostMapping("/admin/users")
    public List<String> getLdapUsers(@RequestBody User user) throws NamingException {
        return dataDao.getLdapUsers(user);
    }

    @RequestMapping(value = "/admin/delete/{item}", method = RequestMethod.DELETE)
    public String deleteAdmin(@PathVariable("item") String item) throws IOException {
        return dataDao.deleteAdmin(item);
    }

}
