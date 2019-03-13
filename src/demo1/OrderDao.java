package demo1;

public class OrderDao {
    /**
     *
     * @author XW
     *
     **/
    public void save(){
        System.out.println ("保存");
    }
    public void update(){
        System.out.println ("修改");
    }
    public String delete(){
        System.out.println ("删除");
        return "返回值";
    }
    public void find(){
        int i = 1/0;
        System.out.println ("查询");
    }
}
