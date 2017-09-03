import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {RouterModule, Routes} from "@angular/router";
import {BaseRequestOptions, HttpModule} from "@angular/http";
import {AppComponent} from "./app.component";
import {Home} from "./components/home/app.home";
import { NgbModule} from "@ng-bootstrap/ng-bootstrap";
import { BookingRequestService } from "./components/_services/booking-request.service";
import { MeetingService } from "./components/_services/meeting.service";
import ConstantsService from "./components/_util/constants.service";


var routes: Routes =[
    { path: '',component:Home },
    { path: '**', redirectTo: '' }
];

@NgModule({
    imports:[RouterModule.forRoot(routes),BrowserModule,FormsModule,HttpModule,NgbModule.forRoot()],
    declarations: [
        Home,
        AppComponent,
    ],
    providers: [
        ConstantsService,
        BookingRequestService,
        MeetingService,
        BaseRequestOptions
    ],
    bootstrap: [AppComponent]
})
export class AppModule{}