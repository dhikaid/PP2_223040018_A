package dao;

import db.MysqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Member;

public class MemberDao {
    public int insert(Member member){
        int result = -1;
        try(Connection connection = MysqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO member (id, nama, tanggal_lahir, alamat, email, no_hp) VALUES(?,?,?,?,?,?)");
            statement.setString(1, member.getId());
            statement.setString(2, member.getNama());
            statement.setString(3, member.getTanggalLahir());
            statement.setString(4, member.getAlamat());
            statement.setString(5, member.getEmail());
            statement.setString(6, member.getNoHP());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int update(Member member){
        int result = -1;
        try(Connection connection = MysqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE member SET nama = ?, tanggal_lahir = ?, alamat = ?, email = ?,no_hp = ? WHERE id = ?");
            statement.setString(1, member.getNama());
            statement.setString(2, member.getTanggalLahir());
            statement.setString(3, member.getAlamat());
            statement.setString(4, member.getEmail());
            statement.setString(5, member.getNoHP());
            statement.setString(6, member.getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int delete(Member member){
        int result = -1;
        try(Connection connection = MysqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM member WHERE id = ?");
            statement.setString(1, member.getId());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Member> findAll(){
        List<Member> list = new ArrayList<>();
        try(Connection connection = MysqlConnection.getInstance().getConnection(); Statement statement = connection.createStatement();){
           try(ResultSet resultSet = statement.executeQuery("SELECT * FROM member");){
                while(resultSet.next()){
                    Member member = new Member();
                    member.setId(resultSet.getString("id"));
                    member.setNama(resultSet.getString("nama"));
                    member.setTanggalLahir(resultSet.getString("tanggal_lahir"));
                    member.setAlamat(resultSet.getString("alamat"));
                    member.setEmail(resultSet.getString("email"));
                    member.setNoHP(resultSet.getString("no_hp"));
                    list.add(member);
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
