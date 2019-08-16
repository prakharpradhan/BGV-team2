import { TestBed } from '@angular/core/testing';

import { DocumentUploadService } from './document-upload.service';

describe('DocumentUploadService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DocumentUploadService = TestBed.get(DocumentUploadService);
    expect(service).toBeTruthy();
  });
});
