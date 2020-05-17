public class HiddenWord {
    private String word;
    
    public HiddenWord(String word) {
        this.word = word;
    }

    public String getHint(String guess) {
        String hint = "";
        for (int i = 0; i < guess.length(); i++) {
            String shortGuess = guess.substring(i, i + 1);
            String shortWord = word.substring(i, i + 1);
            if (shortGuess.equals(shortWord)) {
                hint += shortGuess;
            } else if (word.indexOf(shortGuess) != -1) {
                hint += "+";
            } else {
                hint += "*";
            }
        }
        return hint;
    }
}