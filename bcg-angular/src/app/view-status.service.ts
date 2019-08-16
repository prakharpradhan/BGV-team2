import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ViewStatusService {

  constructor(private http: HttpClient) { }
  /**
   * view status of uploaded document
   * @param empId 
   */
  viewDocStatus(empId: any): Observable<any[]> {

    var url_total = 'http://3.92.213.155:8080/viewStatus/' + empId;
    return this.http.get<any[]>(url_total);
  }
}
