import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { MatCardModule } from '@angular/material/card';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatChipsModule } from '@angular/material/chips';

import { HttpClientModule } from '@angular/common/http';
import { MatTooltipModule } from '@angular/material/tooltip';
import { ListingService } from './listing.service';
import { MessageService } from './message.service';
import { ListOfCategoriesComponent } from './list-of-categories/list-of-categories.component';
import { CategoryOfQuestionsComponent } from './category-of-questions/category-of-questions.component';
import { SearchComponent } from './search/search.component';
import { QuestionDetailsComponent } from './question-details/question-details.component';
import { MatDividerModule } from '@angular/material/divider';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule } from '@angular/material/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { QuestionsListComponent } from './questions-list/questions-list.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { TextFieldModule } from '@angular/cdk/text-field';
import { RichTextEditorAllModule } from '@syncfusion/ej2-angular-richtexteditor';
import { NgxFileDropModule } from 'ngx-file-drop';
import { MatMenuModule } from '@angular/material/menu';

import { AddQuestionDialogComponent } from './add-question-dialog/add-question-dialog.component';
import { AddQaEntryComponent } from './add-qa-entry/add-qa-entry.component';
import { FiltersComponent } from './filters/filters.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MainComponent } from './main/main.component';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatRippleModule } from '@angular/material/core';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { DragDropDirective } from './DragDropDirective';
import { ReviewQuestionsComponent } from './review-questions/review-questions.component';
import { ApprovalStageComponent } from './approval-stage/approval-stage.component';
import { HomeComponent } from './home/home.component';
import { PreviousRouteService } from './previous-route.service';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { AuthGuardService } from './auth-guard.service';
import { AuthService } from './auth.service';
import { AdministrationComponent } from './administration/administration.component';
import { EditDialogComponent } from './edit-dialog/edit-dialog.component';
import { ConfirmationDialogComponent } from './confirmation-dialog/confirmation-dialog.component';
import { ManageComponent } from './manage/manage.component';

@NgModule({
  declarations: [
    AppComponent,
    ListOfCategoriesComponent,
    CategoryOfQuestionsComponent,
    SearchComponent,
    QuestionDetailsComponent,
    QuestionsListComponent,
    AddQuestionDialogComponent,
    AddQaEntryComponent,
    FiltersComponent,
    LoginComponent,
    FiltersComponent,
    DashboardComponent,
    MainComponent,
    DragDropDirective,
    ReviewQuestionsComponent,
    ApprovalStageComponent,
    HomeComponent,
    AdministrationComponent,
    EditDialogComponent,
    ConfirmationDialogComponent,
    ManageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatCardModule,
    MatToolbarModule,
    MatButtonModule,
    MatTooltipModule,
    MatInputModule,
    MatChipsModule,
    MatDividerModule,
    MatIconModule,
    MatDialogModule,
    MatAutocompleteModule,
    MatSnackBarModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,
    TextFieldModule,
    ReactiveFormsModule,
    HttpClientModule,
    RichTextEditorAllModule,
    NgxFileDropModule,
    MatMenuModule,
    MatProgressSpinnerModule,
    MatRippleModule,
    MatFormFieldModule,
    MatSelectModule
  ],
  providers: [ListingService, MessageService, PreviousRouteService, AuthGuardService, AuthService],
  bootstrap: [AppComponent],
  entryComponents: [AddQuestionDialogComponent, EditDialogComponent, ConfirmationDialogComponent]
})
export class AppModule { }
