import { TestBed } from '@angular/core/testing';

import { ViewStatusService } from './view-status.service';

describe('ViewStatusService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ViewStatusService = TestBed.get(ViewStatusService);
    expect(service).toBeTruthy();
  });
});
