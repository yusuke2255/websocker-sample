import { MysamplesPage } from './app.po';

describe('mysamples App', function() {
  let page: MysamplesPage;

  beforeEach(() => {
    page = new MysamplesPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
