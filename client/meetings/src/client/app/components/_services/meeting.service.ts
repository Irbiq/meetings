/**
 * Created by ASUS on 03.09.2017.
 */


import { Injectable } from "@angular/core";
import { Http } from "@angular/http";
import ConstantsService from "../_util/constants.service";
import { BookingRequest } from "../_models/booking-request";
@Injectable()
export class MeetingService{

    constructor(private http: Http){ }

    addRequestAndMeeting(bookingRequest:BookingRequest){
        return this.http.post(ConstantsService.apiUrl+'/meeting/add/request',bookingRequest);
    }

    addAllBookingRequestsToMeetingsJson(bookingRequests:Array<BookingRequest>){
        return this.http.post(ConstantsService.apiUrl+'/meeting/add/requests/json',bookingRequests);
    }

    addAllBookingRequestsToMeetingsDb(){
        return this.http.post(ConstantsService.apiUrl+'/meeting/add/requests/db',[]);
    }

    getAll(){
        return this.http.get(ConstantsService.apiUrl+'/meeting/all')
    }
}