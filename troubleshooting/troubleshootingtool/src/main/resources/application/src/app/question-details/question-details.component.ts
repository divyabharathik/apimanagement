import { Component, OnInit, Input } from '@angular/core';
import { ListingService } from '../listing.service';
import { ActivatedRoute, Router } from '@angular/router';
import { QAEntry } from '../data-models/QAEntry';
import { Question } from '../data-models/Question';
import { Answer } from '../data-models/Answer';

@Component({
  selector: 'app-question-details',
  templateUrl: './question-details.component.html',
  styleUrls: ['./question-details.component.css']
})
export class QuestionDetailsComponent implements OnInit {

  constructor(private listingService: ListingService, private router: Router, private route: ActivatedRoute) { }

  response: any;
  postedDate: any;
  ans_count: number;
  @Input() id: string;

  ngOnInit() {

    this.id = this.listingService.id;
    this.route.paramMap.subscribe(params => {
      this.id = params.get('id');
    });
    this.listingService.getQuestionForID(this.id).subscribe(
      data => {
        console.log('Questions for ' + this.id + ' successful ', data);
        this.response = data;
      },
      res => { console.log(res); });
  }

  display() {
    (document.getElementById('display') as HTMLInputElement).style.display = 'block';
    window.scrollTo(0, document.body.scrollHeight);
  }




  getQuestion(): QAEntry {
    return this.response;
  }
  onTagClick(tag: string) {
    console.log('clicked ' + tag);
    this.listingService.keyword = tag;
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() =>
      this.router.navigate(['/search/' + tag]));
    // this.router.navigateByUrl('/cat');
  }


  post_ans() {

    const answer = (document.getElementById('answer') as HTMLInputElement).value;
    if (answer == '') {
      alert('Please add your answer');
    }
    else {
      const d = new Date();
      let qa_entry = this.response;
      const creationDate = d.getMilliseconds();
      this.ans_count = 0;
      const ques = new Question(this.id, qa_entry.Question.category, qa_entry.Question.question, qa_entry.Question.description,
        qa_entry.Question.attachment, qa_entry.Question.creationDate, qa_entry.Question.ownerId, qa_entry.Question.lastModifiedDate);
      const ans = new Answer('123', answer, creationDate, 'y509476', 'user', creationDate, 0, false);
      // this.response.Answers.push(ans);
      let answers: Array<Answer>;
      answers = qa_entry.Answers;
      answers.push(ans);
      this.ans_count = this.ans_count + 1;
      const qa = new QAEntry(ques, answers, qa_entry.tags, true, answers.length, 0);
      this.listingService.post_answer(qa, this.id).subscribe(
        data => {
          console.log('put Request is successful ', data);
          // this.response = data;
          // this.router.navigateByUrl('/qnas/' + this.id);
          // this.ngOnInit();
          window.location.reload();
        }
      );
      (document.getElementById('display') as HTMLInputElement).style.display = 'none';
      (document.getElementById('answer') as HTMLInputElement).value = '';
    }
  }
}
