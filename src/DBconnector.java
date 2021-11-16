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
        private  static final String PASS = "snr94sps";


       private  Connection conn = null;
        //connection = https://www.javatpoint.com/Connection-interface
        //https://www.javatpoint.com/steps-to-connect-to-the-database-in-java

        private Statement stmt = null;
//fra Geis

        public static void main(String[] args) {
            //til at teste database objektet
            DBconnector dbc = new DBconnector();

            ArrayList<Team> placeholder = new ArrayList<>();
            Team tenThumbs = new Team("Ten Thumbs","Kaj","MANDrea",69);
            placeholder.add(tenThumbs);

            dbc.writeTeamsToDataBase(placeholder);

        } 


        public DBconnector(){//constructor, class og filename skal matche - ellers vil JDK ikke oversætte. :(((((( sad emoji

            //STEP 2: Register JDBC driver
            // Class.forName("com.mysql.jdbc.Driver"); //kan være nødvendig.
            System.out.println("Connecting to database...");
            try {
                conn = DriverManager.getConnection(DB_URL,USER,PASS);
                if(conn!=null){
                    System.out.println("Connection made");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }


        public  void writeTeamsToDataBase(ArrayList<Team> arrayListOfTeams){

            //https://www.javatpoint.com/PreparedStatement-interface
            try{
                String sqlStringDerSkalUdføres = "insert into ";
                //lav en SQL String først i MySQL Workbench - og indsæt den her. Brug (?,?,?)
                //https://www.javatpoint.com/PreparedStatement-interface
                //https://www.geeksforgeeks.org/how-to-use-preparedstatement-in-java/
                //http://tutorials.jenkov.com/jdbc/preparedstatement.html 
                
                
                PreparedStatement prep = conn.prepareStatement(sqlStringDerSkalUdføres);
                //den skal have en SQL Query - kan vi få en fra Workbench? :thinking:
                prep.execute();
            }catch (SQLException ex){

            }
            //hvad ved I om PreparedStatements?

            //



        }

        //hvad skal vi have ud af databasen?
        //holdnavne - 1, 2, alle?
        //spilleres navne for et hold
        //hvad med matches?

        public ArrayList<Team> getTeams(){
            //declare a placeholder to store shit in
            ArrayList<Team> output=null;



            return output;
            //En metode uden return giver intet tilbage.
        }


        //@Override
        public String[] readTeamData() {
            String[] team_data = new String[40];

            try{


                //STEP 3: Open a connection


                //STEP 4: Execute a query
                System.out.println("Creating statement...");
                stmt = conn.createStatement();


                String sql = "SELECT * FROM Team";
                ResultSet rs = stmt.executeQuery(sql);

                //STEP 5: Extract data from result set
                while(rs.next()){
                    //Retrieve by column name
                    int id  = rs.getInt("id");

                   // team_data[id-1]=id+","+teamName+","+Player1+","+Player2;

                }
                //STEP 6: Clean-up environment
                rs.close();
                stmt.close();
                conn.close();
            }catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
            }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
            }finally{
                //finally block used to close resources
                try{
                    if(stmt!=null)
                        stmt.close();
                }catch(SQLException se2){
                }// nothing we can do
                try{
                    if(conn!=null)
                        conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }//end finally try
            }//end try


            return team_data;
        }
    }
