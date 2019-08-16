import { TestBed } from '@angular/core/testing';

import { BgTeamService } from './bg-team.service';

describe('BgTeamService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BgTeamService = TestBed.get(BgTeamService);
    expect(service).toBeTruthy();
  });
});
