package chess.domain.game;

import java.util.Map;

import chess.domain.board.Board;
import chess.domain.board.coordinate.Coordinate;
import chess.domain.piece.Piece;

public class BlackTurn implements State {

	private final Board board;

	public BlackTurn(Board board) {
		this.board = board;
	}

	@Override
	public State start() {
		throw new IllegalStateException("이미 게임을 시작한 상태입니다.");
	}

	@Override
	public State end() {
		return new End(board);
	}

	@Override
	public State move(Coordinate from, Coordinate to) {
		Piece piece = board.findByCoordinate(from);

		if (piece.isWhite()) {
			throw new IllegalStateException("검은팀 차례에서는 검은색 말만 이동할 수 있습니다.");
		}

		Board newBoard = board.move(from, to);

		if (!newBoard.isBothKingAlive()) {
			return new End(board);
		}
		return new WhiteTurn(newBoard);
	}

	@Override
	public Map<Coordinate, Piece> getValue() {
		return board.getValue();
	}

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
	public boolean isFinished() {
		return false;
	}

    @Override
    public String getState() {
        return "BlackTurn";
    }
}
