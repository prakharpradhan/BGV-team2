import { TestBed } from '@angular/core/testing';

import { LoginCommonServiceService } from './login-common-service.service';

describe('LoginCommonServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LoginCommonServiceService = TestBed.get(LoginCommonServiceService);
    expect(service).toBeTruthy();
  });
});
