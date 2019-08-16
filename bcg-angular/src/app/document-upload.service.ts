import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { IDocument } from './IDocument';

@Injectable({
  providedIn: 'root'
})
export class DocumentUploadService {



  constructor(private httpClient: HttpClient) { }


/**
 * uploaddocument
 * @param documentToUpload 
 */
  uploadDocument(documentToUpload: File): Observable<any[]> {
    const endpoint = "http://3.92.213.155:8080/upload";
    const formData: FormData = new FormData();
    formData.append('file', documentToUpload, documentToUpload.name);

    let headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    let options = {
      headers: headers
    }

    return this.httpClient.post<any[]>(endpoint, formData);

  }
/**
 * 
 * @param doc upload file data
 */
  uploadFile(doc: IDocument): Observable<any[]> {
    const endpoint = "http://3.92.213.155:8080/uploadDocument";
    return this.httpClient.post<any[]>(endpoint, doc);
  }
}
