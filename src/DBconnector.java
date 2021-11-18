import java.sql.*;
import java.util.ArrayList;




    public class DBconnector {
//Den her kllasse - skal KUN arbejde med databasen. Hvor den får tingene fra = doesn't matter.

        /*
        1: sikre at vi får forbindelse til en database, korrekt.
        2. Sikre at vi kan læse noget fra databasen

        3. Sikre at vi har en metode til at skrive fra den.

         */
        // database URL og parametre.
        private static final String DB_URL = "jdbc:mysql://localhost/Tournament";
        //Hvad hedder Schema, som den forsøger at connecte til? Tournament
        //  Database credentials
        private static final String USER = "root";
        private static final String PASS = "pellepelle";


        private Connection conn = null;
        //connection = https://www.javatpoint.com/Connection-interface
        //https://www.javatpoint.com/steps-to-connect-to-the-database-in-java

        private Statement stmt = null;
//fra Geis



        public DBconnector() {//constructor, class og filename skal matche - ellers vil JDK ikke oversætte. :(((((( sad emoji

            // Class.forName("com.mysql.jdbc.Driver"); //kan være nødvendig.
            System.out.println("Connecting to database...");
            try {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                if (conn != null) {
                    System.out.println("Connection made");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }


        public void writeTeamsToDataBase(ArrayList<Team> arrayListOfTeams) {
            Connection conn = null;

            try {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);

                String sqlStringDerSkalUdføres = "REPLACE INTO Team (teamName, Player1, Player2) VALUES(?,?,?)";

                int i=0;
                PreparedStatement prep = conn.prepareStatement(sqlStringDerSkalUdføres);
                for (int q = 0; q < arrayListOfTeams.size(); q++) {
                Team team = arrayListOfTeams.get(i);
                    prep.setString(1,team.teamName);
                    prep.setString(2,team.player1);
                    prep.setString(3,team.player2);
                    prep.addBatch();
                    i++;

                }
                prep.executeBatch();

            } catch (SQLException ex) {
                System.out.println(ex);

            }



        }



        public ArrayList<Team> getTeams() {
            //declare a placeholder to store shit in
            ArrayList<Team> output = null;


            return output;
            //En metode uden return giver intet tilbage.
        }


        public ArrayList<Team> readTeamData() {
            ArrayList<Team> dbTeamArray = new ArrayList<>();

            try {

                System.out.println("Creating statement...");
                stmt = conn.createStatement();


                String sql = "SELECT * FROM Team";
                ResultSet rs = stmt.executeQuery(sql);

                int i=0;
                while (rs.next()) {
                    //Retrieve by column name
                    String teamName = rs.getString("teamName");
                    String Player1 = rs.getString("Player1");
                    String Player2 = rs.getString("Player2");


                    dbTeamArray.add(new Team (teamName, Player1, Player2,i+1));
                    i++;

                }
                //STEP 6: Clean-up environment
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException se) {
                //Handle errors for JDBC
                se.printStackTrace();
            } catch (Exception e) {
                //Handle errors for Class.forName
                e.printStackTrace();
            } finally {
                //finally block used to close resources
                try {
                    if (stmt != null)
                        stmt.close();
                } catch (SQLException se2) {
                }// nothing we can do
                try {
                    if (conn != null)
                        conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }//end finally try
            }//end try


            return dbTeamArray;
        }

        public ArrayList<Team> readMatchData() {
            ArrayList<Team> dbTeamArray = new ArrayList<>();

            try {

                System.out.println("Creating statement...");
                stmt = conn.createStatement();


                String sql = "SELECT * FROM Team";
                ResultSet rs = stmt.executeQuery(sql);

                int i=0;
                while (rs.next()) {
                    //Retrieve by column name
                    String teamName = rs.getString("teamName");
                    String Player1 = rs.getString("Player1");
                    String Player2 = rs.getString("Player2");


                    dbTeamArray.add(new Team (teamName, Player1, Player2,i+1));
                    i++;
                    System.out.println(teamName);
                }
                //STEP 6: Clean-up environment
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException se) {
                //Handle errors for JDBC
                se.printStackTrace();
            } catch (Exception e) {
                //Handle errors for Class.forName
                e.printStackTrace();
            } finally {
                //finally block used to close resources
                try {
                    if (stmt != null)
                        stmt.close();
                } catch (SQLException se2) {
                }// nothing we can do
                try {
                    if (conn != null)
                        conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }//end finally try
            }//end try


            return dbTeamArray;
        }
/*
        public void printDB() throws SQLException {
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dictionary_db?user=root&password=snr94sps");
                 PreparedStatement statement = connection.prepareStatement("SELECT * FROM Team");
                 ResultSet results = statement.executeQuery();) {

                while (results.next()) {
                    int id = results.getInt(1);
                    String teamName = results.getString("teamName");
                    String player1 = results.getString("Player1");
                    String player2 = results.getString("Player2");
                    System.out.println("Id: " + id + ", teamName: " + teamName + ", Player1: " + player1 +",Player2: " + player2);
                }

            } catch (SQLException ex) {
                System.out.println("Error while communicating with the database");

            }*/
        }
    //}



