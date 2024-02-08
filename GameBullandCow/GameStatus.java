package GameBullandCow;
public enum GameStatus {
    INIT, START, RESTART, EXIT, LOSE("Вы проиграли"), WIN("Вы выиграли");
    private String description;

    GameStatus(String description) {
        this.description = description;
    }

    GameStatus() {
    }

    public String getDescription(){ return description;}
}