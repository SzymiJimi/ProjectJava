import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Szymon on 2017-05-04.
 */
public class Cars {
    public static Object[][] getHavingCars(Statement statem) throws Exception
    {
        String sqlCount= "Select count(*) FROM na_stanie";
        String sql = "SELECT id_st, nazwa_st, min_placa FROM stanowiska";
        ResultSet resultCount = statem.executeQuery(sqlCount);
        ResultSet rs = statem.executeQuery(sql);
        int quantity= resultCount.getInt("count(*)");
        Object[][] data=new Object[quantity][3];
        for(int j=0;j<3;j++)
        {
            for(int k=0;k<11;k++)
            {
                data[k][j]= new Object();
            }
        }
        int i=0;
        while(rs.next()){
            //Retrieve by column name
            int id  = rs.getInt("id_st");
            String nazwa = rs.getString("nazwa_st");
            int min_p = rs.getInt("min_placa");

            data[i][0]=new Integer(id);
            data[i][1]=nazwa;
            data[i][2]=new Integer(min_p);

            //Display values
            System.out.print("ID: " + id);
            System.out.print(", Nazwa: " + nazwa);
            System.out.println(", Placa: " + min_p);
            i++;
        }
        rs.close();
        return data;
    }
}
