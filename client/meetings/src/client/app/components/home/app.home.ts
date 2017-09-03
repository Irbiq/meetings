import { Component, OnInit } from '@angular/core';
import { Response } from "@angular/http";
import { BookingRequest } from "../_models/booking-request";
import { BookingRequestService } from "../_services/booking-request.service";
import { MeetingService } from "../_services/meeting.service";
import { Meeting } from "../_models/meeting";

@Component({
    selector: 'home',
    templateUrl: './home.html',
    //styleUrls: [require('./home.css').toString()]
})
export class Home implements OnInit {

    private bookingRequests: Array<BookingRequest>;
    private meetings: Array<Meeting>;
    private bookingRequest:string;
    private meetingRequest:string;

    private brPlaceholder:string= 'Adds a meeting request to the booking_requests table in the database: \n' +
        '{"id":0,' +
        '"employee":"EMP1",' +
        '"requestTime":"2017-09-03 16:27:32",' +
        '"meetingTime":"2017-09-03 16:27:32",' +
        '"meetingDuration":1}';
    private mPlaceholder:string ='Sends a request with list of booking requests (in json format), ' +
        'converts it into meetings and saves to the meeting table in the database: \n'+
        '[{"id":0,' +
        '"employee":"EMP1",' +
        '"requestTime":"2017-09-03 16:27:32",' +
        '"meetingTime":"2017-09-03 16:27:32",' +
        '"meetingDuration":1}]\n' +
        'Sends a request with booking request (in json format), ' +
        'converts it into meeting and saves to the meeting table in the database:  '+
        '{"id":0,' +
        '"employee":"EMP1",' +
        '"requestTime":"2017-09-03 16:27:32",' +
        '"meetingTime":"2017-09-03 16:27:32",' +
        '"meetingDuration":1}';

    constructor(private bookingRequestService:BookingRequestService,
                private meetingService:MeetingService) {}

    ngOnInit(): void {
        this.bookingRequestService.getAll().subscribe((response:Response)=>{
            this.bookingRequests = JSON.parse(response['_body']);
        });
        this.meetingService.getAll().subscribe((response:Response)=>{
            this.meetings = JSON.parse(response['_body']);
        });
    }

    getAllBookingRequests(){
        this.bookingRequestService.getAll().subscribe((response:Response)=>{
            this.bookingRequests = JSON.parse(response['_body']);
        });
        console.log(this.bookingRequests);
    }

    addBookingRequest(){
        let br:BookingRequest = JSON.parse(this.bookingRequest)
        this.bookingRequestService.add(br).subscribe();

    }

    getAllMeetings(){
        this.meetingService.getAll().subscribe((response:Response)=>{
            this.meetings = JSON.parse(response['_body']);
        });
        console.log(this.meetings);
    }

    addRequestAndMeeting(){
        let br:BookingRequest = JSON.parse(this.meetingRequest)
        this.meetingService.addRequestAndMeeting(br).subscribe();
        this.getAllMeetings();
    }

    addAllBookingRequestsToMeetingsJson(){
        let requests:Array<BookingRequest> = JSON.parse(this.meetingRequest);
        this.meetingService.addAllBookingRequestsToMeetingsJson(requests).subscribe((response:Response)=>{
            this.meetings = JSON.parse(response['_body']);
        });
    }

    addAllBookingRequestsToMeetingsDb(){
        this.meetingService.addAllBookingRequestsToMeetingsDb().subscribe((response:Response)=>{
            this.meetings = JSON.parse(response['_body']);
        });
    }
}
