


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

    public class MotorSQL {

        private Connection conn;
        private Statement st;
        private ResultSet rs;
        private static final String URL = "booking.cakx2yrcohzg.us-east-1.rds.amazonaws.com";
        private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
        private static final String USER = "Leyre";
        private static final String PASS = "12345678";

        public void connect() {
            try {


                conn = DriverManager.getConnection(URL, USER, PASS);


                st = conn.createStatement();


            }
            catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        public int execute(String sql) {
            int resp = 0;
            try {
                resp = st.executeUpdate(sql);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return resp;
        }

        public ResultSet executeQuery(String sql) {
            try {
                rs = st.executeQuery(sql);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return rs;
        }

        public void disconnect() {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
            }
        }

    }


