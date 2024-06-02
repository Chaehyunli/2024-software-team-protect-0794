class SurveyServiceTest {

    @InjectMocks
    private SurveyService surveyService;

    @Mock
    private SurveyRepository surveyRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateSurvey_Success() {
        int club_id = 1;
        String title = "Test Survey";
        String description = "This is a test survey";
        LocalDateTime start_date = LocalDateTime.now();
        LocalDateTime end_date = start_date.plusDays(1);
        String[] questions = {"Q1", "Q2"};

        when(surveyRepository.saveSurvey(any(Survey.class))).thenReturn(true);

        boolean result = surveyService.create_survey(club_id, title, description, start_date, end_date, questions);
        assertTrue(result);
        verify(surveyRepository, times(1)).saveSurvey(any(Survey.class));
    }

    @Test
    void testUpdateSurvey_Success() {
        int survey_id = 1;
        Survey survey = new Survey();
        survey.setId(survey_id);
        survey.setTitle("Updated Title");
        survey.setDescription("Updated Description");
        survey.setStart_date(LocalDateTime.now());
        survey.setEnd_date(LocalDateTime.now().plusDays(1));
        survey.setQuestions(new String[]{"Q1", "Q2"});

        when(surveyRepository.getSurvey(survey_id)).thenReturn(survey);
        when(surveyRepository.updateSurvey(survey)).thenReturn(true);

        boolean result = surveyService.update_survey(survey_id);
        assertTrue(result);
        verify(surveyRepository, times(1)).getSurvey(survey_id);
        verify(surveyRepository, times(1)).updateSurvey(survey);
    }

    @Test
    void testDeleteSurvey_Success() {
        int survey_id = 1;
        Survey survey = new Survey();
        survey.setId(survey_id);

        when(surveyRepository.getSurvey(survey_id)).thenReturn(survey);
        when(surveyRepository.deleteSurvey(survey_id)).thenReturn(true);

        boolean result = surveyService.delete_survey(survey_id);
        assertTrue(result);
        verify(surveyRepository, times(1)).getSurvey(survey_id);
        verify(surveyRepository, times(1)).deleteSurvey(survey_id);
    }

    @Test
    void testPublishSurvey_Success() {
        int survey_id = 1;
        Survey survey = new Survey();
        survey.setId(survey_id);

        when(surveyRepository.getSurvey(survey_id)).thenReturn(survey);
        when(survey.publish(survey_id)).thenReturn(true);

        boolean result = surveyService.publish_survey(survey_id);
        assertTrue(result);
        verify(surveyRepository, times(1)).getSurvey(survey_id);
    }

    @Test
    void testUnpublishSurvey_Success() {
        int survey_id = 1;
        Survey survey = new Survey();
        survey.setId(survey_id);

        when(surveyRepository.getSurvey(survey_id)).thenReturn(survey);
        when(survey.unPublish(survey_id)).thenReturn(true);

        boolean result = surveyService.unpublish_survey(survey_id);
        assertTrue(result);
        verify(surveyRepository, times(1)).getSurvey(survey_id);
    }

    @Test
    void testSubmitSurveyResponse_Success() {
        int survey_id = 1;
        int member_id = 1;
        String[] responses = {"A1", "A2"};
        Survey survey = new Survey();
        survey.setId(survey_id);
        survey.setQuestions(new String[]{"Q1", "Q2"});

        when(surveyRepository.getSurvey(survey_id)).thenReturn(survey);
        when(surveyRepository.saveSurveyResponse(survey_id, member_id, responses)).thenReturn(true);

        boolean result = surveyService.submit_survey_response(survey_id, member_id, responses);
        assertTrue(result);
        verify(surveyRepository, times(1)).getSurvey(survey_id);
        verify(surveyRepository, times(1)).saveSurveyResponse(survey_id, member_id, responses);
    }
}
