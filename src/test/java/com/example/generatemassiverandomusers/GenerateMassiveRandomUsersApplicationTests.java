package com.example.generatemassiverandomusers;

import com.example.generatemassiverandomusers.entity.Users;
import com.example.generatemassiverandomusers.service.UsersService;
import com.example.generatemassiverandomusers.utils.RandomValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SpringBootTest
class GenerateMassiveRandomUsersApplicationTests {
    private Integer begin = 0;//起始id
    private long end = begin + 1000;//每次循环插入的数据量
    @Autowired
    UsersService usersService;


    @Test
    public void insertBigData2() {
        //创建一个人实例
        Users person = new Users();
        //计开始时间
        long bTime = System.currentTimeMillis();
        //开始循环，循环次数1W次。
        while (begin < end) {
            //为person赋值
            person.setId(begin);
            person.setName(RandomValue.getChineseName());
            person.setSex(RandomValue.name_sex);
            person.setAge(RandomValue.getNum(1, 100));
            person.setEmail(RandomValue.getEmail(4, 15));
            person.setTel(RandomValue.getTel());
            person.setAddress(RandomValue.getRoad());
            //执行插入语句
            usersService.save(person);
            begin++;
        }
        //计结束时间
        long eTime = System.currentTimeMillis();
        System.out.println("插入1W条数据耗时：" + (eTime - bTime));
    }

    @Test
    public void insertOneUser() {
        Users oneRandomUser = RandomValue.getOneRandomUser();
        usersService.save(oneRandomUser);
    }

}