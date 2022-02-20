import java.sql.*;

public class FighterDao {
    public final Connection connection;

    public FighterDao() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fight_styles_db", "root", "qwerty123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setFighter(Fighter fighter) throws SQLException {
        int style = checkStyle(connection, fighter.getStyle());
        int country = checkCountry(connection, fighter.getNationality());
        PreparedStatement statement = connection.prepareStatement("insert into fighter(name, first_name, " +
                "country_id_country, style_id_style) values ('" + fighter.getSurname() + "', '" + fighter.getFirstName() + "', " + country + ", " + style + ");");
        statement.executeUpdate();
    }

    public static int checkStyle(Connection connection, String style) throws SQLException {
        int styleId = 0;
        PreparedStatement statement = connection.prepareStatement("select id_style from style where name = '" + style + "'");
        ResultSet styl = statement.executeQuery();
        while (styl.next()) {
            styleId = styl.getInt("id_style");
        }
        return styleId;
    }

    public static int checkCountry(Connection connection, String nationality) throws SQLException {
        int countryId = 0;
        PreparedStatement statement = connection.prepareStatement("select id_country from country where country_name = '" + nationality + "'");
        ResultSet country = statement.executeQuery();
        while (country.next()) {
            countryId = country.getInt("id_country");
        }
        return countryId;
    }
    public void getFighters() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select fighter.name as nazwisko, fighter.first_name as imie, style.name as styl, country.country_name as narodowosc from fighter inner join style on fighter.style_id_style = style.id_style inner join country on fighter.country_id_country = country.id_country");
        ResultSet set = statement.executeQuery();

        while (set.next()) {
            System.out.printf(" %s %s - %s, %s, %n", set.getString("nazwisko"), set.getString("imie"), set.getString("styl"), set.getString("narodowosc"));
        }
    }
}
