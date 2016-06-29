package cn.csbit.form;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
/**
 * Created by wushifeng on 2016/6/28.
 */
public class PersonForm {
    @Size(max=100,min=4,message="字符长度在4到100之间")
    private String firstName;

    @Min(value=10,message="年龄最小不能小于10")
    @Max(value=120,message="年龄最大不能超过120")
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
