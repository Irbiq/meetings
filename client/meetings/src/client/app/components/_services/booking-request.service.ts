import { Injectable } from "@angular/core";
import ConstantsService from "../_util/constants.service";
import { Http } from "@angular/http";
import { BookingRequest } from "../_models/booking-request";

@Injectable()
export class BookingRequestService {

    constructor(private http: Http) {
    }

    add(bookingRequest: BookingRequest) {
        return this.http.post(ConstantsService.apiUrl + "/booking/add", bookingRequest);
    }

    getAll() {
        return this.http.get(ConstantsService.apiUrl + "/booking/all")
    }
}