package easy;

import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {

    public static void main(String[] args) {

        String[][] competitionMatches = new String[][] {
                { TEAM_HTML, TEAM_C_SHARP }, { TEAM_C_SHARP, TEAM_PYTHON }, { TEAM_PYTHON, TEAM_HTML }
        };
        int[] winResults = new int[] { AWAY_TEAM, AWAY_TEAM, HOME_TEAM };

        System.out.println(getTornamentWinner(competitionMatches, winResults));
    }

    public static int AWAY_TEAM = 0;
    public static int HOME_TEAM = 1;
    public static String TEAM_HTML = "HTML";
    public static String TEAM_C_SHARP = "C#";
    public static String TEAM_PYTHON = "PYTHON";

    /**
     * Determines the winner of a tournament based on match results.
     * Each winning team receives 3 points per match won.
     * The team with the most points at the end is the tournament winner.
     * 
     * @param competitionMatches A 2D array where each inner array contains
     *                           [awayTeam, homeTeam]
     * @param results            An array indicating the winner of each match (0 for
     *                           away team, 1 for home team)
     * @return The name of the team that won the tournament (has the highest score)
     * 
     *         Time Complexity: O(n) where n is the number of matches in the
     *         tournament
     *         Space Complexity: O(k) where k is the number of unique teams in the
     *         tournament
     */
    public static String getTornamentWinner(String[][] competitionMatches, int[] results) {
        // Track scores for each team
        Map<String, Integer> scores = new HashMap<>();

        // Points awarded for a win
        final int WIN_POINTS = 3;

        // Keep track of the current best team
        String currentBestTeam = "";
        scores.put(currentBestTeam, 0); // Initialize with default value

        // Process each match
        for (int i = 0; i < competitionMatches.length; i++) {
            // Get the competing teams
            String homeTeam = competitionMatches[i][0];
            String awayTeam = competitionMatches[i][1];

            // Determine the winner based on the result
            String winningTeam = results[i] == HOME_TEAM ? homeTeam : awayTeam;

            // Update the winning team's score
            scores.put(winningTeam, scores.getOrDefault(winningTeam, 0) + WIN_POINTS);

            // Update the current best team if necessary
            if (scores.get(winningTeam) > scores.get(currentBestTeam)) {
                currentBestTeam = winningTeam;
            }
        }

        return currentBestTeam;
    }

    class Score {
        String team;
        int score;

        public Score(String team, int score) {
            this.team = team;
            this.score = score;
        }
    }

}