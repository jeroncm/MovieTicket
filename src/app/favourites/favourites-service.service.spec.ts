import { TestBed } from '@angular/core/testing';

import { FavouritesServiceService } from './favourites-service.service';

describe('FavouritesServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FavouritesServiceService = TestBed.get(FavouritesServiceService);
    expect(service).toBeTruthy();
  });
});
