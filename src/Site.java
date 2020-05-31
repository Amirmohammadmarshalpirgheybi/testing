import org.w3c.dom.Node;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.security.*;
import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class Site {

    static void initial(){
        File fie = new File("HW.txt");
        try {
            int counter=0;
            Scanner console=new Scanner(fie);
            do {
                String line=console.nextLine();
                if(line.equals("Users:")){}
                else if(line.equals("Courses:"))
                    counter++;
                else if(counter==0){
                    Neededlist.studentArraylist.add(new Student(line));
                }
                else if (counter==1){
                    Neededlist.courseArraylist.add(new Course(line));
                }
            }while (console.hasNextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        initial();

        for(int i=0;i<Neededlist.studentArraylist.size();i++){
                Neededlist.studentArraylist.get(i).courseListbuilder(Neededlist.studentArraylist.get(i).courses);
                Neededlist.studentArraylist.get(i).print();
        }
          Entrance entrance = new Entrance();

    }
        //for(int i=0;i<Neededlist.courseArraylist.size();i++)
          //  Neededlist.courseArraylist.get(i).print();


}
class Student{
    void courseListbuilder(String[] tokens){
        for(int i=0;i<tokens.length;i++) {
            tokens[i]=tokens[i].replaceAll("(\\W{0,1})(\\d+,\\d+)(\\W{0,1})", "$2");
            String[] course=tokens[i].split(",");
            for(int j=0;j<Neededlist.courseArraylist.size();j++){
                if(Neededlist.courseArraylist.get(j).courseID.equals(course[0])){
                    if (Neededlist.courseArraylist.get(j).group.equals(course[1])){
                        this.courseArrayList.add(Neededlist.courseArraylist.get(j));
                    }
                }
            }
    }
    }
   public  ArrayList<Course> courseArrayList=new ArrayList<Course>();
 String name,ID,username,major,branch,guide;
 String[] courses;
 Student(String line){
     name=line.replaceAll("^(\\w+\\s+\\w+\\s)(.*)","$1");
     ID=line.replaceAll("^(\\w+\\s+\\w+\\s{2})(\\d+)(\\s{2}.*)","$2");
     username=line.replaceAll("^(\\w+\\s+\\w+\\s{2})(\\d+\\s{2})(\\S+)(\\s{2}.*)","$3");
     major=line.replaceAll("^(\\w+\\s+\\w+\\s{2})(\\d+\\s{2})(\\S+\\s{2})(\\w+\\s{1}\\w+)(\\s{2}.*)","$4");
     branch=line.replaceAll("^(\\w+\\s+\\w+\\s{2})(\\d+\\s{2})(\\S+\\s{2})(\\w+\\s{1}\\w+\\s{2})(\\w+|\\w+\\s\\w+)(\\s{2}.*)","$5");
     guide=line.replaceAll("^(\\w+\\s+\\w+\\s{2})(\\d+\\s{2})(\\S+\\s{2})(\\w+\\s{1}\\w+\\s{2})(\\w+\\s{2}|\\w+\\s\\w+\\s{2})(Dr\\.\\s\\w+)(\\s{2}.*)","$6");
     courses=line.replaceAll("^(\\w+\\s+\\w+\\s{2})(\\d+\\s{2})(\\S+\\s{2})(\\w+\\s{1}\\w+\\s{2})(\\w+\\s{2}|\\w+\\s\\w+\\s{2})(Dr\\.\\s\\w+\\s{2})(\\[)(.*)(\\])|^(\\w+\\s+\\w+\\s{2})(\\d+\\s{2})(\\S+\\s{2})(\\w+\\s{1}\\w+\\s{2})(\\w+\\s{2}|\\w+\\s\\w+\\s{2})(Dr\\.\\s\\w+)(\\W{0})(\\s{2}nan)","$8").split("\\),\\(");
    // for(int i=0;i<courses.length;i++){
      //   courseArrayList.add(Neededlist.courseArraylist.get(searchCouse(courses[i])));
     //}

 }
 public void print(){
     System.out.println(name+"\t"+ID+"\t"+username+"\t"+major+"\t"+branch+"\t"+guide+"\t"+courses);
 }
}
 class Course{
    String courseID,group,unit,precourse,name,register,total,master,finaldate,time,furthurinformation;
    Course(String line){
        courseID=line.replaceAll("^(\\d+)(\\s{2}.*)","$1");
        group=line.replaceAll("^(\\d+\\s{2})(\\d{1})(\\s{2}.*)","$2");
        unit=line.replaceAll("^(\\d+\\s{2})(\\d{1}\\s{2})(\\d{1})(\\s{2}.*)","$3");
        precourse=line.replaceAll("^(\\d+\\s{2})(\\d{1}\\s{2})(\\d{1}\\s{2})(\\d+(,\\d+)*|nan)(\\s{2}.*)","$4");
        name=line.replaceAll("^(\\d+\\s{2})(\\d{1}\\s{2})(\\d{1}\\s{2})(\\d+(,\\d+)*\\s{2}|nan\\s{2})(\\S+(\\s\\S+)*)(\\s{2}.*)","$6");
        register=line.replaceAll("^(\\d+\\s{2})(\\d{1}\\s{2})(\\d{1}\\s{2})(\\d+(,\\d+)*\\s{2}|nan\\s{2})(\\S+(\\s\\S+)*\\s{2})(\\d+)(\\s{2}.*)","$8");
        total=line.replaceAll("^(\\d+\\s{2})(\\d{1}\\s{2})(\\d{1}\\s{2})(\\d+(,\\d+)*\\s{2}|nan\\s{2})(\\S+(\\s\\S+)*\\s{2})(\\d+\\s{2})(\\d+)(\\s{2}.*)","$9");
        master=line.replaceAll("^(\\d+\\s{2})(\\d{1}\\s{2})(\\d{1}\\s{2})(\\d+(,\\d+)*\\s{2}|nan\\s{2})(\\S+(\\s\\S+)*\\s{2})(\\d+\\s{2})(\\d+\\s{2})(Dr\\.\\s\\w+)(\\s{2}.*)","$10");
        finaldate=line.replaceAll("^(\\d+\\s{2})(\\d{1}\\s{2})(\\d{1}\\s{2})(\\d+(,\\d+)*\\s{2}|nan\\s{2})(\\S+(\\s\\S+)*\\s{2})(\\d+\\s{2})(\\d+\\s{2})(Dr\\.\\s\\w+\\s{2})(\\S+)(\\s{2}.*)","$11");
        time=line.replaceAll("^(\\d+\\s{2})(\\d{1}\\s{2})(\\d{1}\\s{2})(\\d+(,\\d+)*\\s{2}|nan\\s{2})(\\S+(\\s\\S+)*\\s{2})(\\d+\\s{2})(\\d+\\s{2})(Dr\\.\\s\\w+\\s{2})(\\S+\\s{2})(\\S+)(\\s{2}.*)","$12");
        furthurinformation=line.replaceAll("^(\\d+\\s{2})(\\d{1}\\s{2})(\\d{1}\\s{2})(\\d+(,\\d+)*\\s{2}|nan\\s{2})(\\S+(\\s\\S+)*\\s{2})(\\d+\\s{2})(\\d+\\s{2})(Dr\\.\\s\\w+\\s{2})(\\S+\\s{2})(\\S+\\s{2})(.*)","$13");
    }
    Course(Course course1,boolean x){
        if(x==false){
            courseID=course1.courseID;
            group= course1.group;
            unit=course1.unit;
            precourse=course1.precourse;
            name=course1.name;
            register=Integer.toString(Integer.parseInt(course1.register)-1);
            total=course1.total;
            master=course1.master;
            finaldate=course1.finaldate;
            time=course1.time;
            furthurinformation=course1.furthurinformation;
        }
        if(x==true){
            courseID=course1.courseID;
            group= course1.group;
            unit=course1.unit;
            precourse=course1.precourse;
            name=course1.name;
            register=Integer.toString(Integer.parseInt(course1.register)+1);
            total=course1.total;
            master=course1.master;
            finaldate=course1.finaldate;
            time=course1.time;
            furthurinformation=course1.furthurinformation;
        }
    }
    public void print(){
        System.out.println(courseID+"\t"+group+"\t"+unit+"\t"+precourse+"\t"+name+"\t"+register+"\t"+total+"\t"+master+"\t"+finaldate+"\t"+time+"\t"+furthurinformation);
    }
 }
 interface Neededlist{
     public static ArrayList<Student> studentArraylist=new ArrayList<Student>();
     public static ArrayList<Course> courseArraylist=new ArrayList<Course>();

 }
class Entrance extends JFrame{

    private final JTextField textField1,textField2;
    public String username=new String();
    public String password= new String();
    private final JPasswordField passwordField1;
    private final JLabel label1,label2,label3,label4;
    private final JButton button1,button2;
    SecureRandom random=new SecureRandom();
    int radompassword=1000+random.nextInt(9000);
    public Entrance(){
        setSize(1920,720);
        textField1=new JTextField(45);
        textField1.setBounds(getWidth()/2-280+400,getHeight()/2-100-100,300,40);
        add(textField1);
        label1=new JLabel("نام کاربری:");
        label1.setBounds(1000+400,230-105,100,100);
        Font font1=new Font("Serif",Font.BOLD,20);
        label1.setFont(font1);
        add(label1);
        label2=new JLabel("رمز عبور:");
        label2.setBounds(1000+400,230-105+100,100,100);
        label2.setFont(font1);
        add(label2);
        passwordField1=new JPasswordField(45);
        passwordField1.setBounds(getWidth()/2-280+400,getHeight()/2-100,300,40);
        add(passwordField1);
        label3=new JLabel(Integer.toString(radompassword));
        label3.setFont(new Font("ALGERIAN",Font.ITALIC|Font.BOLD,25));
        label3.setHorizontalAlignment(JLabel.CENTER);
        label3.setOpaque(true);
        label3.setBackground(Color.RED);
        label3.setForeground(Color.BLUE);
        label3.setBounds(getWidth()/2-280+400+80,350,100,40);
        Border border1=BorderFactory.createLineBorder(Color.red,3,true);
        label3.setBorder(border1);
        add(label3);
        ImageIcon icon1=new ImageIcon("icon1.png");
        Image image=icon1.getImage();
        image=image.getScaledInstance(40,40,java.awt.Image.SCALE_SMOOTH);
        icon1=new ImageIcon(image);
        button1=new JButton("",icon1);
        button1.setBounds(getWidth()/2-280+400,350,40,40);
        button1.setToolTipText("CLICK TO REFRESH");
        add(button1);
        button2=new JButton("ورود به سامانه");
        button2.setFont(new Font("ARIAL",Font.BOLD,20));
        button2.setBounds(getWidth()/2-280+400,420,300,40);
        add(button2);
        textField2=new JTextField(20);
        textField2.setBounds(getWidth()/2-280+400+200,350,100,40);
        textField2.setHorizontalAlignment(JTextField.CENTER);
        textField2.setFont(new Font("ARIAL",Font.BOLD,20));
        textField2.setToolTipText("کد رو به رو را وارد کنید");
        add(textField2);
        ImageIcon icon2 = new ImageIcon("icon2.jpg");
        Image image1=icon2.getImage();
        image1=image1.getScaledInstance(1000,850,java.awt.Image.SCALE_SMOOTH);
        icon2=new ImageIcon(image1);
        label4=new JLabel(icon2);
        label4.setBounds(0,0,1000,850);
        add(label4);
        Buttonhandler1 hander1_1 =new Buttonhandler1();
        button1.addActionListener(hander1_1);
        Buttonhandler2 handler1_2=new Buttonhandler2();
        button2.addActionListener(handler1_2);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private class Buttonhandler1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            radompassword=1000+random.nextInt(9000);
            label3.setText(Integer.toString(radompassword));
        }
    }
    private class Buttonhandler2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(textField2.getText().equals(Integer.toString(radompassword)))
            {
                username=textField1.getText();
                password=passwordField1.getText();
                System.out.println(username+"\t"+password);
                int counter3=0;
                for(int i=0;i<Neededlist.studentArraylist.size();i++) {
                    if(Neededlist.studentArraylist.get(i).ID.equals(username))
                    {
                        if(Neededlist.studentArraylist.get(i).username.equals((String) password)){
                           dispose();
                           MainPage mainPage = new MainPage(i);
                           counter3++;
                           break;
                        }

                    }

                }
                if (counter3==0)
                {
                    JOptionPane.showMessageDialog(Entrance.this,"رمز عبور درست وارد نشده است!");
                    radompassword=1000+random.nextInt(9000);
                    label3.setText(Integer.toString(radompassword));
                }
            }
            else{
                radompassword=1000+random.nextInt(9000);
                label3.setText(Integer.toString(radompassword));
                JOptionPane.showMessageDialog(Entrance.this,"کدکپچا درست وارد نشده است!");
                textField2.setText("");
            }
        }
    }


}
class MainPage extends JFrame{
  // private final JMenuBar menuBar1;
  int ID1;
   private final JMenu menu1,menu2,menu3;
   private final JTabbedPane tabbedPane1;
   private final JPanel panel1,panel2,panel3;
   private final JMenuItem item1,item2,item3,item4,item5,item6,item7,item8,item9,item10;
   private final JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label13,label14;
   private final JTextField textField1,textField2;
   public final JLabel label12;
   private final JComboBox comboBox1;
   private final JButton button1;

    public MainPage(int x){
        ID1=x;
        System.out.println(ID1);
        setSize(1850,850);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        label1=new JLabel(" شماره دانشجویی:"+Neededlist.studentArraylist.get(ID1).ID);
        label1.setForeground(new Color(150,150,150));
        label1.setFont(new Font("Cambra",Font.BOLD,15));
        label1.setBounds(1420-100,90+120,200,50);
        label1.setHorizontalAlignment(JLabel.RIGHT);
        add(label1);
        label2=new JLabel("نام و نام خانوادگی:"+Neededlist.studentArraylist.get(ID1).name);
        label2.setForeground(new Color(150,150,150));
        label2.setFont(new Font("Cambra",Font.BOLD,15));
        label2.setBounds(1120-110,90+120,210,50);
        label2.setHorizontalAlignment(JLabel.RIGHT);
        add(label2);
        label3=new JLabel("دانشکده:"+Neededlist.studentArraylist.get(ID1).major);
        label3.setForeground(new Color(150,150,150));
        label3.setFont(new Font("Cambra",Font.BOLD,15));
        label3.setBounds(820-100,90+120,200,50);
        label3.setHorizontalAlignment(JLabel.RIGHT);
        add(label3);
        label4=new JLabel(" رشته:"+Neededlist.studentArraylist.get(ID1).major);
        label4.setForeground(new Color(150,150,150));
        label4.setFont(new Font("Cambra",Font.BOLD,15));
        label4.setBounds(1420-100,115+120,200,50);
        label4.setHorizontalAlignment(JLabel.RIGHT);
        add(label4);
        label5=new JLabel("گرایش:"+Neededlist.studentArraylist.get(ID1).branch);
        label5.setForeground(new Color(150,150,150));
        label5.setFont(new Font("Cambra",Font.BOLD,15));
        label5.setBounds(1120-100,115+120,200,50);
        label5.setHorizontalAlignment(JLabel.RIGHT);
        add(label5);
        label6=new JLabel("استاد راهنما:"+Neededlist.studentArraylist.get(ID1).guide);
        label6.setForeground(new Color(150,150,150));
        label6.setFont(new Font("Cambra",Font.BOLD,15));
        label6.setBounds(820-100,115+120,200,50);
        label6.setHorizontalAlignment(JLabel.RIGHT);
        add(label6);
        label7=new JLabel("پست الکترونیکی شما:");
        label7.setForeground(new Color(200,0,0));
        label7.setFont(new Font("Cambra",Font.BOLD,17));
        label7.setBounds(1385,120,140,50);
        label7.setHorizontalAlignment(JLabel.RIGHT);
        add(label7);
        label8=new JLabel("نیمسال دوم 99-1398");
        label8.setForeground(new Color(0,0,0));
        label8.setFont(new Font("Cambra",Font.BOLD,17));
        label8.setBounds(1000,40+120,180,50);
        label8.setHorizontalAlignment(JLabel.CENTER);
        add(label8);
        label9=new JLabel("درس:");
        label9.setForeground(new Color(100,100,100));
        label9.setFont(new Font("Cambra",Font.BOLD,15));
        label9.setBounds(1420,200+120,100,50);
        label9.setHorizontalAlignment(JLabel.RIGHT);
        add(label9);
        textField1=new JTextField(20);
        textField1.setBounds(1385,210+120,100,30);
        textField1.setHorizontalAlignment(JTextField.CENTER);
        add(textField1);
        label10=new JLabel("واحد:");
        label10.setForeground(new Color(100,100,100));
        label10.setFont(new Font("Cambra",Font.BOLD,15));
        label10.setBounds(1250,200+120,100,50);
        label10.setHorizontalAlignment(JLabel.RIGHT);
        add(label10);
        textField2=new JTextField(5);
        textField2.setBounds(1260,210+120,50,30);
        textField2.setHorizontalAlignment(JTextField.CENTER);
        add(textField2);
        label11=new JLabel("گروه:");
        label11.setForeground(new Color(100,100,100));
        label11.setFont(new Font("Cambra",Font.BOLD,15));
        label11.setBounds(1150,200+120,100,50);
        label11.setHorizontalAlignment(JLabel.RIGHT);
        add(label11);
        String[] text1={"1","2","3","4"};
        comboBox1=new JComboBox(text1);
        comboBox1.setBounds(1160,210+120,50,30);
        add(comboBox1);
        button1=new JButton("اضافه");
        button1.setBounds(1050,210+120,70,30);
        button1.setBackground(new Color(150,100,255));
        button1.setFont(new Font("Cambra",Font.BOLD,15));
        Border border2=BorderFactory.createLineBorder(null, 2 , false);
        button1.setBorder(border2);
        add(button1);

        /*menuBar1=new JMenuBar();
        menuBar1.setLocation(100,100);
        menuBar1.setBounds(100,100,1850,50);
        menuBar1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);*/
        Color color2 = new Color(130,0 ,255 );
        Color color1=new Color(200, 50, 100);
        Border border1=BorderFactory.createLineBorder(color2, 2 , true);
        //menuBar1.setBackground(color1);
        //menuBar1.setBorder(border1);
        label12=new JLabel("اطلاعیه ثبت نام و ترمیم");
        label12.setForeground(new Color(0,0,0));
        label12.setFont(new Font("Cambra",Font.BOLD,15));
        label12.setOpaque(true);
        label12.setBounds(10,135,130,30);
        label12.setForeground(color1);
        label12.setHorizontalAlignment(JLabel.CENTER);
        add(label12);
        tabbedPane1=new JTabbedPane();
        panel1=new JPanel();
        panel2=new JPanel();
        panel3=new JPanel();
        tabbedPane1.setBounds(0,65,1550,70);
        panel1.setBounds(200,0,100,100);

        tabbedPane1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
       // tabbedPane1.addTab(" اطلاعیه ثبت نام و ترمیم",panel1);
      //  tabbedPane1.addTab("خدمات آموزشی",panel2);
        //tabbedPane1.addTab("امور کارنامه",panel3);
        //tabbedPane1.setBackground(color1);
        add(tabbedPane1);
        JInternalFrame jInternalFrame = new JInternalFrame();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)jInternalFrame.getUI()).setNorthPane(null);
        JMenuBar jMenuBar = new JMenuBar();
        menu1=new JMenu("  اطلاعیه ثبت نام و ترمیم  ");
        menu1.setFont(new Font("Cambra",Font.CENTER_BASELINE,15));
        menu2=new JMenu(" خدمات آموزشی  ");
        menu2.setFont(new Font("Cambra",Font.CENTER_BASELINE,15));
        menu3=new JMenu("امور کارنامه  ");
        menu3.setFont(new Font("Cambra",Font.CENTER_BASELINE,15));
        item1=new JMenuItem("وضعیت تحصیلی و ریزنمرات دانشجو");
        item2=new JMenuItem(" لیست نمرات موقت و ثبت اعتراض");
        item3=new JMenuItem(" فرم ثبت نام دانشجو");
        item4=new JMenuItem("لیست امتحانات پایان ترم");
        item5=new JMenuItem("برنامه هفتگی دانشجو");
        item6=new JMenuItem("درخواست های آموزشی");
        item7=new JMenuItem("اطلاعیه و راهنمای ثبت نام و ترمیم");
        item8=new JMenuItem("لیست دروس ارایه شده دانشکده ها در ترم جاری");
        item9=new JMenuItem("فرم مشاوره انتخاب واحد");


        item10=new JMenuItem("پرداخت اینترنتی دانشجویان");
        jMenuBar.add(menu1);
        jMenuBar.add(menu2);
        jMenuBar.add(menu3);
        menu1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        menu1.setBounds(100,100,30,30);
        menu2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        menu3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        item1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        item1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        item2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        item3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        item4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        item5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        item6.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        item7.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        item8.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        item9.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        item10.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        menu1.addMouseListener(new MenuActionListener1());menu2.addMouseListener(new MenuActionListener2());menu3.addMouseListener(new MenuActionListener3());
        item1.addActionListener(new MenuItemActionListener());item2.addActionListener(new MenuItemActionListener());item3.addActionListener(new MenuItemActionListener());item4.addActionListener(new MenuItemActionListener());item5.addActionListener(new MenuItemActionListener());item6.addActionListener(new MenuItemActionListener());item7.addActionListener(new MenuItemActionListener());item8.addActionListener(new MenuItemActionListener());item9.addActionListener(new MenuItemActionListener());item10.addActionListener(new MenuItemActionListener());
        menu3.add(item1);menu3.add(item2);
        menu1.add(item3);menu1.add(item4);menu1.add(item5);menu1.add(item6);
        menu2.add(item7);menu2.add(item8);menu2.add(item9);menu2.add(item10);
        jMenuBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        jInternalFrame.setJMenuBar(jMenuBar);
        tabbedPane1.addTab("", jInternalFrame);
        ImageIcon icon3=new ImageIcon("icon3.png");
        Image image=icon3.getImage();
        image=image.getScaledInstance(80,80, Image.SCALE_SMOOTH);
        icon3=new ImageIcon(image);
        label13=new JLabel(icon3);

        label13.setBounds(10,5,80,80);
        add(label13);
        ImageIcon icon4=new ImageIcon("icon4.png");
        Image image1=icon4.getImage();
        image1=image1.getScaledInstance(120,70,Image.SCALE_SMOOTH);
        icon4=new ImageIcon(image1);
        label14=new JLabel(icon4);
        label14.setBounds(1400,5,120,70);
        add(label14);
        String[] colnames={"شماره درس","گروه","واحد","پیش نیازها","نام درس","تعداد ثبت نامی ها","ظرفیت کل","نام استاد","تازیخ امتحان","زمان کلاس","توضیحات"};
        String[][] data;
        data=new String[Neededlist.studentArraylist.get(ID1).courseArrayList.size()+1][];
        for(int i=0;i<data.length-1;i++){
            data[i]=new String[11];
            data[i][0]=Neededlist.studentArraylist.get(ID1).courseArrayList.get(i).courseID;
            data[i][1]=Neededlist.studentArraylist.get(ID1).courseArrayList.get(i).group;
            data[i][2]=Neededlist.studentArraylist.get(ID1).courseArrayList.get(i).unit;
            data[i][3]=Neededlist.studentArraylist.get(ID1).courseArrayList.get(i).precourse;
            data[i][4]=Neededlist.studentArraylist.get(ID1).courseArrayList.get(i).name;
            data[i][5]=Neededlist.studentArraylist.get(ID1).courseArrayList.get(i).register;
            data[i][6]=Neededlist.studentArraylist.get(ID1).courseArrayList.get(i).total;
            data[i][7]=Neededlist.studentArraylist.get(ID1).courseArrayList.get(i).master;
            data[i][8]=Neededlist.studentArraylist.get(ID1).courseArrayList.get(i).finaldate;
            data[i][9]=Neededlist.studentArraylist.get(ID1).courseArrayList.get(i).time;
            data[i][10]=Neededlist.studentArraylist.get(ID1).courseArrayList.get(i).furthurinformation;
        }
        data[data.length-1]=new String[11];
        //for(int i=0;i<data.length;i++)
        //data[data.length-1][2]=Integer.toString(Integer.parseInt(data[data.length-1][2])+Integer.parseInt(data[i][2]));
        for(int i=0;i<data.length-1;i++){
            for(int j=0;j<data[i].length;j++){
                System.out.print(data[i][j]+"\t");
            }
            System.out.println();
        }

        jInternalFrame.setLayout(null);
        DefaultTableModel model=new DefaultTableModel(data,colnames);
        JTable table=new JTable(model);
        DefaultTableCellRenderer cellRenderer=new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        JButton jButton1 = new JButton("حذف درس");
        jButton1.setBackground(color1);
        jButton1.setBounds(500,500,1000,30);
        add(jButton1);

        JScrollPane jScrollPane=new JScrollPane(table);
        jScrollPane.setBounds(500,400,1000,100);
        table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        table.getColumnModel().getColumn(0).setPreferredWidth(35);
        table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
        table.getColumnModel().getColumn(1).setPreferredWidth(3);
        table.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
        table.getColumnModel().getColumn(2).setPreferredWidth(3);
        table.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
        table.getColumnModel().getColumn(3).setPreferredWidth(35);
        table.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
        table.getColumnModel().getColumn(4).setPreferredWidth(110);
        table.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
        table.getColumnModel().getColumn(5).setPreferredWidth(40);
        table.getColumnModel().getColumn(5).setCellRenderer(cellRenderer);
        table.getColumnModel().getColumn(6).setPreferredWidth(25);
        table.getColumnModel().getColumn(6).setCellRenderer(cellRenderer);
        table.getColumnModel().getColumn(7).setPreferredWidth(30);
        table.getColumnModel().getColumn(7).setCellRenderer(cellRenderer);
        table.getColumnModel().getColumn(8).setPreferredWidth(40);
        table.getColumnModel().getColumn(8).setCellRenderer(cellRenderer);
        table.getColumnModel().getColumn(9).setPreferredWidth(120);
        table.getColumnModel().getColumn(9).setCellRenderer(cellRenderer);
        table.getColumnModel().getColumn(10).setPreferredWidth(110);
        table.getColumnModel().getColumn(10).setCellRenderer(cellRenderer);
        add(jScrollPane);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (table.getSelectedRow()!=-1)
                {

                    for(int i=0;i<Neededlist.courseArraylist.size();i++)
                    {

                            if(Neededlist.courseArraylist.get(i).courseID.equals(table.getValueAt(table.getSelectedRow(),0))){
                                if(Neededlist.courseArraylist.get(i).unit.equals(table.getValueAt(table.getSelectedRow(),2))){
                                    if(Neededlist.courseArraylist.get(i).group.equals(table.getValueAt(table.getSelectedRow(),1))){

                                        Neededlist.studentArraylist.get(ID1).courseArrayList.remove(Neededlist.courseArraylist.get(i));
                                        Neededlist.courseArraylist.set(i,new Course(Neededlist.courseArraylist.get(i),false));

                                    }
                                }
                            }

                    }
                    model.removeRow(table.getSelectedRow());
                    JOptionPane.showMessageDialog(null,"دروس مدنظر حذف شد!");

                }
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int counte1=0,counter2=0;
                for(int i=0;i<Neededlist.courseArraylist.size();i++)
                {
                    if(Neededlist.courseArraylist.get(i).courseID.equals(textField1.getText())){
                        if(Neededlist.courseArraylist.get(i).unit.equals(textField2.getText())){
                            if(Neededlist.courseArraylist.get(i).group.equals(comboBox1.getSelectedItem())){
                                for(int j=0;j<Neededlist.studentArraylist.get(ID1).courseArrayList.size();j++){
                                    if(Neededlist.studentArraylist.get(ID1).courseArrayList.get(j).name.equals(Neededlist.courseArraylist.get(i).name))
                                    {
                                        if (Neededlist.studentArraylist.get(ID1).courseArrayList.get(j).group.equals(comboBox1.getSelectedItem())){
                                            counter2++;
                                        }
                                    }
                                }
                    if(counter2==0){
                                model.removeRow(table.getRowCount()-1);
                               Neededlist.courseArraylist.set(i,new Course(Neededlist.courseArraylist.get(i),true));
                               Neededlist.studentArraylist.get(ID1).courseArrayList.add(Neededlist.courseArraylist.get(i));
                               model.addRow(new Object[]{Neededlist.courseArraylist.get(i).courseID,Neededlist.courseArraylist.get(i).group,Neededlist.courseArraylist.get(i).unit,Neededlist.courseArraylist.get(i).precourse,Neededlist.courseArraylist.get(i).name,Neededlist.courseArraylist.get(i).register,Neededlist.courseArraylist.get(i).total,Neededlist.courseArraylist.get(i).master,Neededlist.courseArraylist.get(i).finaldate,Neededlist.courseArraylist.get(i).time,Neededlist.courseArraylist.get(i).furthurinformation});
                               model.addRow(new Object[]{"","","","","","","","","","",""});
                               counte1++;
                               break;
                            }
                    else{
                        JOptionPane.showMessageDialog(null,"درس مدنظر در چارت شما قرار دارد.");
                        break;
                    }

                        }

                    }

                    }

                }

                if(counte1==0&&counter2==0){
                    JOptionPane.showMessageDialog(null,"اطلاهات درس نادرست وارد شده است.");
                }
            }
        });

        /*menu1=new JMenu("اطلاعیه ثبت نام و ترمیم  ");
        menu1.setFont(new Font("Cambra",Font.CENTER_BASELINE,15));
        menu2=new JMenu("خدمات آموزشی  ");
        menu2.setFont(new Font("Cambra",Font.CENTER_BASELINE,15));
        menu3=new JMenu("امور کارنامه  ");
        menu3.setFont(new Font("Cambra",Font.CENTER_BASELINE,15));
        item1=new JMenuItem("وضعیت تحصیلی و ریزنمرات دانشجو");
        item2=new JMenuItem(" لیست نمرات موقت و ثبت اعتراض");
        item3=new JMenuItem(" فرم ثبت نام دانشجو");
        item4=new JMenuItem("لیست امتحانات پایان ترم");
        item5=new JMenuItem("برنامه هفتگی دانشجو");
        item6=new JMenuItem("درخواست های آموزشی");
        item7=new JMenuItem("طلاعیه و راهنمای ثبت نام و ترمیم");
        item8=new JMenuItem("یست دروس ارایه شده دانشکده ها در ترم جاری");
        item9=new JMenuItem("فرم مشاوره انتخاب واحد");
        item10=new JMenuItem("پرداخت اینترنتی دانشجویان");
        menuBar1.add(menu1);
        menuBar1.add(menu2);
        menuBar1.add(menu3);
        menu1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        //menu1.setBounds(100,100,30,30);
        menu2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        menu3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        item1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        item1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        item2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        item3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        item4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        item5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        item6.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        item7.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        item8.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        item9.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        item10.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        menu3.add(item1);menu3.add(item2);
        menu1.add(item3);menu1.add(item4);menu1.add(item5);menu1.add(item6);
        menu2.add(item7);menu2.add(item8);menu2.add(item9);menu2.add(item10);
        setJMenuBar(menuBar1);*/

        setLayout(null);
        setVisible(true);
}
class MenuItemActionListener extends JFrame implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(this,"شما اجازه دسترسی به این بخش را ندارید!!");
    }
}

class MenuActionListener1 extends JFrame implements MouseListener {



    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        label12.setText("اطلاعیه ثبت نام و ترمیم");
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        System.out.printf("%d,%d\n",mouseEvent.getX(),mouseEvent.getY());
        label12.setText("اطلاعیه ثبت نام و ترمیم");
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

        label12.setText("اطلاعیه ثبت نام و ترمیم");
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
    class MenuActionListener2 extends JFrame implements MouseListener {



        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            label12.setText("خدمات آموزشی");
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            System.out.printf("%d,%d\n",mouseEvent.getX(),mouseEvent.getY());
            label12.setText("خدمات آموزشی");
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

            label12.setText("خدمات آموزشی");
        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }
    class MenuActionListener3 extends JFrame implements MouseListener {



        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            label12.setText("امور کارنامه");
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            System.out.printf("%d,%d\n",mouseEvent.getX(),mouseEvent.getY());
            label12.setText("امور کارنامه");
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

            label12.setText("امور کارنامه");
        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }

}
