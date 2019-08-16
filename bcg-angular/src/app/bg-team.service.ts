import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BgTeamService {

  constructor(private _httpClient: HttpClient) { }

  _urlId = "http://3.92.213.155:8080/emp/";
  _urlName = "http://3.92.213.155:8080/emp/get/";
  _urlApprove = "http://3.92.213.155:8080/approvestatus/";
  _urlReject = "http://3.92.213.155:8080/rejectstatus/";
  /**
   * search emp based on its id and name
   */
  searchEmp(parameter: number, name?: string, id?: number): Observable<any[]> {
    if (name == null && parameter == 1) {

      return this._httpClient.get<any[]>(this._urlId + id);
    }
    else {
      return this._httpClient.get<any[]>(this._urlName + name);
    }
  }
  /**
   * approve document 
   * @param id  
   */
  approveDocument(id: number): Observable<any> {
    return this._httpClient.get<any>(this._urlApprove + id);
  }
  /**
   * rejects Documents
   * @param id 
   */
  rejectDocument(id: number): Observable<any> {
    return this._httpClient.get<any>(this._urlReject + id);
  }
}
