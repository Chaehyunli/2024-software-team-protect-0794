class SurveyControllerTest {

    @InjectMocks
    private SurveyController surveyController;

    @Mock
    private SurveyService surveyService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateSurvey() {
        // Given
        int clubId = 1;
        String title = "Sample Survey";
        String description = "This is a sample survey";
        LocalDateTime startDate = LocalDateTime.now().plusDays(1);
        LocalDateTime endDate = LocalDateTime.now().plusDays(7);
        String[] questions = {"Question 1", "Question 2", "Question 3"};

        // When
        ResponseEntity<Void> response = surveyController.create_survey(clubId, title, description, startDate, endDate, questions);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Additional assertions if needed
    }

    @Test
    void testUpdateSurvey() {
        // Given
        int surveyId = 1;
        String updatedTitle = "Updated Survey";
        String updatedDescription = "This is an updated survey";
        LocalDateTime updatedStartDate = LocalDateTime.now().plusDays(2);
        LocalDateTime updatedEndDate = LocalDateTime.now().plusDays(10);
        String[] updatedQuestions = {"Updated Question 1", "Updated Question 2"};

        // When
        ResponseEntity<Void> response = surveyController.update_survey(surveyId, updatedTitle, updatedDescription, updatedStartDate, updatedEndDate, updatedQuestions);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Additional assertions if needed
    }

    @Test
    void testDeleteSurvey() {
        // Given
        int surveyId = 2;
        Survey existingSurvey = new Survey(1, "Test Survey", "This is a test survey", LocalDateTime.now(), LocalDateTime.now().plusDays(7), new String[]{"Question 1", "Question 2"});
        when(surveyService.get_survey(surveyId)).thenReturn(existingSurvey);
        when(surveyService.delete_survey(surveyId)).thenReturn(true);

        // When
        ResponseEntity<Void> response = surveyController.delete_survey(surveyId);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(surveyService, times(1)).delete_survey(surveyId);
    }

    @Test
    void testGetSurvey() {
        // Given
        int surveyId = 3;
        Survey expectedSurvey = new Survey(1, "Test Survey", "This is a test survey", LocalDateTime.now(), LocalDateTime.now().plusDays(7), new String[]{"Question 1", "Question 2"});
        when(surveyService.get_survey(surveyId)).thenReturn(expectedSurvey);

        // When
        ResponseEntity<Survey> response = surveyController.get_survey(surveyId);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Survey actualSurvey = response.getBody();
        assertNotNull(actualSurvey);
        assertEquals(expectedSurvey.getTitle(), actualSurvey.getTitle());
        assertEquals(expectedSurvey.getDescription(), actualSurvey.getDescription());
        // Additional assertions for other properties of Survey
    }

    @Test
    void testPublishSurvey() {
        // Given
        int surveyId = 4;
        Survey existingSurvey = new Survey(1, "Test Survey", "This is a test survey", LocalDateTime.now(), LocalDateTime.now().plusDays(7), new String[]{"Question 1", "Question 2"});
        when(surveyService.get_survey(surveyId)).thenReturn(existingSurvey);
        when(surveyService.publish_survey(surveyId)).thenReturn(true);

        // When
        ResponseEntity<Void> response = surveyController.publish_survey(surveyId);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(surveyService, times(1)).publish_survey(surveyId);
    }

    @Test
    void testSubmitSurveyResponse() {
        // Given
        int surveyId = 5;
        int memberId = 1;
        String[] responses = {"Response 1", "Response 2", "Response 3"};
        Survey existingSurvey = new Survey(1, "Test Survey", "This is a test survey", LocalDateTime.now(), LocalDateTime.now().plusDays(7), new String[]{"Question 1", "Question 2", "Question 3"});
        when(surveyService.get_survey(surveyId)).thenReturn(existingSurvey);
        when(surveyService.submit_survey_response(surveyId, memberId, responses)).thenReturn(true);

        // When
        ResponseEntity<Void> response = surveyController.submit_survey_response(surveyId, memberId, responses);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(surveyService, times(1)).submit_survey_response(surveyId, memberId, responses);
    }
}
