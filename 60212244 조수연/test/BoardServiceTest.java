class BoardServiceTest {

    @Test
    void testSaveBoardWithValidInput() {
        // Given
        int clubId = 1;
        String name = "Board Name";
        String description = "Board Description";
        Board board = new Board();
        board.setClub_id(clubId);
        board.setName(name);
        board.setDescription(description);
        BoardRepository mockRepository = Mockito.mock(BoardRepository.class);
        Mockito.when(mockRepository.save_board(board)).thenReturn(true);
        BoardService service = new BoardService(mockRepository);

        // When
        boolean result = service.saveBoard(board);

        // Then
        assertTrue(result);
    }

    @Test
    void testSaveBoardWithInvalidName() {
        // Given
        int clubId = 1;
        String name = null;
        String description = "Board Description";
        Board board = new Board();
        board.setClub_id(clubId);
        board.setName(name);
        board.setDescription(description);
        BoardRepository mockRepository = Mockito.mock(BoardRepository.class);
        BoardService service = new BoardService(mockRepository);

        // When
        boolean result = service.saveBoard(board);

        // Then
        assertFalse(result);
    }

    @Test
    void testSaveBoardWithInvalidDescription() {
        // Given
        int clubId = 1;
        String name = "Board Name";
        String description = null;
        Board board = new Board();
        board.setClub_id(clubId);
        board.setName(name);
        board.setDescription(description);
        BoardRepository mockRepository = Mockito.mock(BoardRepository.class);
        BoardService service = new BoardService(mockRepository);

        // When
        boolean result = service.saveBoard(board);

        // Then
        assertFalse(result);
    }

    @Test
    void testGetBoardWithValidId() throws Exception {
        // Given
        int boardId = 1;
        Board expectedBoard = new Board();
        expectedBoard.setId(boardId);
        expectedBoard.setName("Board Name");
        expectedBoard.setDescription("Board Description");
        BoardRepository mockRepository = Mockito.mock(BoardRepository.class);
        Mockito.when(mockRepository.get_board(boardId)).thenReturn(expectedBoard);
        BoardService service = new BoardService(mockRepository);

        // When
        Board actualBoard = service.getBoard(boardId);

        // Then
        assertEquals(expectedBoard, actualBoard);
    }

    @Test
    void testGetBoardWithInvalidId() {
        // Given
        int boardId = -1;
        BoardRepository mockRepository = Mockito.mock(BoardRepository.class);
        BoardService service = new BoardService(mockRepository);

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            service.getBoard(boardId);
        });
    }

}
