package pk.edu.comsats.csquiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;
import java.util.logging.Handler;

public class Game extends AppCompatActivity {


    protected String q="";
    protected String oa="";
    protected String ob="";
    protected String oc="";
    protected String od="";
    protected String answer;
    protected int noq=0;
    protected int money=0,level=1;
    protected int a[]=new int[15];
    public Bundle bundle=new Bundle();
    TextView time;
    MediaPlayer start,background,win,lose;
    Button oaa,obb,occ,odd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        MediaPlayer starttune=MediaPlayer.create(Game.this,R.raw.starttune);
        background=MediaPlayer.create(Game.this,R.raw.background);
        starttune.start();

        final TextView questions=(TextView) findViewById(R.id.question);
        final TextView a=(TextView) findViewById(R.id.optionA);
        final TextView b=(TextView) findViewById(R.id.optionB);
        final TextView c=(TextView) findViewById(R.id.optionC);
        final TextView d=(TextView) findViewById(R.id.optionD);
        TextView level=(TextView) findViewById(R.id.level);
        TextView cashlock=(TextView) findViewById(R.id.cashlock);
        cashlock.setText("CashLock=$0");
        level.setText("Level=1");
        Random rn= new Random();
        final int random=rn.nextInt(10) + 1;
        this.a[noq]=random;
        new CountDownTimer(7000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish(){
        background.start();
        switch (random)
        {
            case 1:
                q="What difference does the 5th generation computer have from other generation computers?";
                oa="Technological advancement";
                ob="Scientific code";
                oc="Object Oriented Programming";
                od="All of the above";
                questions.setText(q);
                a.setText(oa);
                b.setText(ob);
                c.setText(oc);
                d.setText(od);
                answer="Technological advancement";
                break;
            case 2:
                q="Which of the following computer language is used for artificial intelligence?";
                oa="FORTRAN";
                ob="PROLOG";
                oc="C";
                od="D";
                questions.setText(q);
                a.setText(oa);
                b.setText(ob);
                c.setText(oc);
                d.setText(od);
                answer="PROLOG";
                break;
            case 3:
                q="A computer program that converts assembly language to machine language is";
                oa="Compiler";
                ob="Interpreter";
                oc="Assembler";
                od="Comparator";
                questions.setText(q);
                a.setText(oa);
                b.setText(ob);
                c.setText(oc);
                d.setText(od);
                answer="Assembler";
                break;
            case 4:
                q="The section of the CPU that selects, interprets and sees to the execution of program instructions";
                oa="Memory";
                ob="Register unit";
                oc="Control unit";
                od="ALU";
                questions.setText(q);
                a.setText(oa);
                b.setText(ob);
                c.setText(oc);
                d.setText(od);
                answer="Control unit";
                break;
            case 5:
                q="A common boundary between two systems is called";
                oa="Interdiction";
                ob="Interface";
                oc="Surface";
                od="None of the above";
                questions.setText(q);
                a.setText(oa);
                b.setText(ob);
                c.setText(oc);
                d.setText(od);
                answer="Interface";
                break;
            case 6:
                q="Which output device is used for translating information from a computer into pictorial form on paper";
                oa="Mouse";
                ob="Plotter";
                oc="Touch panel";
                od="Card punch";
                questions.setText(q);
                a.setText(oa);
                b.setText(ob);
                c.setText(oc);
                d.setText(od);
                answer="Plotter";
                break;
            case 7:
                q="The first generation of computers available was based on the bit micro processors";
                oa="4";
                ob="8";
                oc="16";
                od="64";
                questions.setText(q);
                a.setText(oa);
                b.setText(ob);
                c.setText(oc);
                d.setText(od);
                answer="8";
                break;
            case 8:
                q="Compilers and interpreters are themselves";
                oa="High-level language";
                ob="Codes";
                oc="Programs";
                od="Mnemonics";
                questions.setText(q);
                a.setText(oa);
                b.setText(ob);
                c.setText(oc);
                d.setText(od);
                answer="Programs";
                break;
            case 9:
                q="A memory that holds micro programs is";
                oa="Core memory";
                ob="ROM";
                oc="RAM";
                od="Control memory";
                questions.setText(q);
                a.setText(oa);
                b.setText(ob);
                c.setText(oc);
                d.setText(od);
                answer="ROM";
                break;
            case 10:
                q="Which of the following is the coding of data so that is can't be easily understood if intercepted";
                oa="Barcode";
                ob="Decoder";
                oc="Encryption";
                od="Mnemonics";
                questions.setText(q);
                a.setText(oa);
                b.setText(ob);
                c.setText(oc);
                d.setText(od);
                answer="Encryption";
                break;
        }
        easytimer.start();}}.start();

    }
    CountDownTimer easytimer=new CountDownTimer(21000,1000) {

        @Override
        public void onTick(long millisUntilFinished) {
            time=(TextView)findViewById(R.id.time);
            time.setText(String.valueOf(millisUntilFinished/1000));
        }

        @Override
        public void onFinish() {
            result();
        }
    };
    CountDownTimer tufftimer=new CountDownTimer(11000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            time=(TextView)findViewById(R.id.time);
            time.setText(String.valueOf(millisUntilFinished/1000));
        }

        @Override
        public void onFinish() {
            result();
        }
    };
        public void CheckA(View optionA) {
            if(oa==""){}
            else{
            background.stop();
            easytimer.cancel();
            tufftimer.cancel();
            win=MediaPlayer.create(Game.this,R.raw.win);
            lose=MediaPlayer.create(Game.this,R.raw.lose);
            TextView cash1 = (TextView) findViewById(R.id.cash);
            oaa=(Button) findViewById(R.id.optionA);
            obb=(Button) findViewById(R.id.optionB);
            occ=(Button) findViewById(R.id.optionC);
            odd=(Button) findViewById(R.id.optionD);
            if (oa == answer) {
                q="";oa="";ob="";oc="";od="";
                noq++;
                if (noq == 1) {
                    money = 500;
                    cash1.setText("$" + money);

                }
                else if(noq==14){
                    money=10000000;
                    cash1.setText("$"+money);
                }
                else
                {
                    money *= 2;
                    cash1.setText("$" + money);

                }
                win.start();
                new CountDownTimer(8000, 1000) {
                    public void onFinish() {
                        oaa.setBackgroundResource(R.drawable.a);
                        gotoNext();
                    }
                    public void onTick(long millisUntilFinished) {
                        oaa.setBackgroundResource(R.drawable.correct);
                    }
                }.start();

            }

            else
            {
                lose.start();
                new CountDownTimer(5000, 1000) {
                    public void onFinish() {
                        oaa.setBackgroundResource(R.drawable.a);
                        result();
                    }
                    public void onTick(long millisUntilFinished) {
                        oaa.setBackgroundResource(R.drawable.wrong);
                        if(ob==answer)
                            obb.setBackgroundResource(R.drawable.correct);
                        if(oc==answer)
                            occ.setBackgroundResource(R.drawable.correct);
                        if(od==answer)
                            odd.setBackgroundResource(R.drawable.correct);

                    }
                }.start();

            }}
        }
        public void CheckB(View optionB){
            if(ob==""){}
            else {
            background.stop();
            easytimer.cancel();
            tufftimer.cancel();
            oaa=(Button)findViewById(R.id.optionA);
            obb=(Button)findViewById(R.id.optionB);
            occ=(Button)findViewById(R.id.optionC);
            odd=(Button)findViewById(R.id.optionD);
            win=MediaPlayer.create(Game.this,R.raw.win);
            lose=MediaPlayer.create(Game.this,R.raw.lose);
            TextView cash1 = (TextView) findViewById(R.id.cash);
            if (ob == answer) {
                q="";oa="";ob="";oc="";od="";
                noq++;
                if (noq == 1) {
                    money = 500;
                    cash1.setText("$" + money);

                }
                else if(noq==14){
                    money=10000000;
                    cash1.setText("$"+money);
                }
                else
                {
                    money *= 2;
                    cash1.setText("$" + money);

                }
                win.start();
                new CountDownTimer(8000, 1000) {
                    public void onFinish() {
                        obb.setBackgroundResource(R.drawable.b);
                        gotoNext();
                    }
                    public void onTick(long millisUntilFinished) {
                        obb.setBackgroundResource(R.drawable.correct);

                    }
                }.start();

            }

            else
            {
                lose.start();
                new CountDownTimer(5000, 1000) {
                    public void onFinish() {
                        obb.setBackgroundResource(R.drawable.b);
                        result();
                    }
                    public void onTick(long millisUntilFinished) {
                        obb.setBackgroundResource(R.drawable.wrong);
                        if(oa==answer)
                            oaa.setBackgroundResource(R.drawable.correct);
                        if(oc==answer)
                            occ.setBackgroundResource(R.drawable.correct);
                        if(od==answer)
                            odd.setBackgroundResource(R.drawable.correct);

                    }
                }.start();
        }}}
        public void CheckC(View optionC){
            if(oc==""){}
            else{
            background.stop();
            easytimer.cancel();
            tufftimer.cancel();
            oaa=(Button)findViewById(R.id.optionA);
            obb=(Button)findViewById(R.id.optionB);
            occ=(Button)findViewById(R.id.optionC);
            odd=(Button)findViewById(R.id.optionD);
            win=MediaPlayer.create(Game.this,R.raw.win);
            lose=MediaPlayer.create(Game.this,R.raw.lose);
            TextView cash1 = (TextView) findViewById(R.id.cash);
            if (oc == answer) {
                q="";oa="";ob="";oc="";od="";
                noq++;
                if (noq == 1) {
                    money = 500;
                    cash1.setText("$" + money);

                }
                else if(noq==14){
                    money=10000000;
                    cash1.setText("$"+money);
                }
                else
                {
                    money *= 2;
                    cash1.setText("$" + money);

                }
                win.start();
                new CountDownTimer(8000, 1000) {
                    public void onFinish() {
                        occ.setBackgroundResource(R.drawable.c);
                        gotoNext();
                    }
                    public void onTick(long millisUntilFinished) {
                        occ.setBackgroundResource(R.drawable.correct);

                    }
                }.start();

            }

            else
            {
                lose.start();
                new CountDownTimer(5000, 1000) {
                    public void onFinish() {
                        occ.setBackgroundResource(R.drawable.c);
                        result();
                    }
                    public void onTick(long millisUntilFinished) {
                        occ.setBackgroundResource(R.drawable.wrong);
                        if(oa==answer)
                            oaa.setBackgroundResource(R.drawable.correct);
                        if(ob==answer)
                            obb.setBackgroundResource(R.drawable.correct);
                        if(od==answer)
                            odd.setBackgroundResource(R.drawable.correct);

                    }
                }.start();
        }}}
        public void CheckD(View optionD){
            if(od==""){}
            else{
            background.stop();
            easytimer.cancel();
            tufftimer.cancel();
            oaa=(Button)findViewById(R.id.optionA);
            obb=(Button)findViewById(R.id.optionB);
            occ=(Button)findViewById(R.id.optionC);
            odd=(Button)findViewById(R.id.optionD);
            win=MediaPlayer.create(Game.this,R.raw.win);
            lose=MediaPlayer.create(Game.this,R.raw.lose);
            TextView cash1 = (TextView) findViewById(R.id.cash);
            if (od == answer) {
                q="";oa="";ob="";oc="";od="";
                noq++;
                if (noq == 1) {
                    money = 500;
                    cash1.setText("$" + money);

                }
                else if(noq==14){
                    money=10000000;
                    cash1.setText("$"+money);
                }
                else
                {
                    money *= 2;
                    cash1.setText("$" + money);

                }
                win.start();
                new CountDownTimer(8000, 1000) {
                    public void onFinish() {
                        odd.setBackgroundResource(R.drawable.d);
                        gotoNext();
                    }
                    public void onTick(long millisUntilFinished) {
                        odd.setBackgroundResource(R.drawable.correct);
                    }
                }.start();

            }

            else
            {
                lose.start();
                new CountDownTimer(5000, 1000) {
                    public void onFinish() {
                        odd.setBackgroundResource(R.drawable.d);
                        result();
                    }
                    public void onTick(long millisUntilFinished) {
                        odd.setBackgroundResource(R.drawable.wrong);
                        if(oa==answer)
                            oaa.setBackgroundResource(R.drawable.correct);
                        if(ob==answer)
                            obb.setBackgroundResource(R.drawable.correct);
                        if(oc==answer)
                            occ.setBackgroundResource(R.drawable.correct);
                    }
                }.start();
        }}}
        public void gotoNext(){
            TextView questions=(TextView) findViewById(R.id.question);
            TextView a=(TextView) findViewById(R.id.optionA);
            TextView b=(TextView) findViewById(R.id.optionB);
            TextView c=(TextView) findViewById(R.id.optionC);
            TextView d=(TextView) findViewById(R.id.optionD);
            TextView level1=(TextView) findViewById(R.id.level);
            TextView time=(TextView) findViewById(R.id.time);
            TextView cashlock=(TextView) findViewById(R.id.cashlock);
            Random rn= new Random();
            background=MediaPlayer.create(Game.this,R.raw.background);
            start=MediaPlayer.create(Game.this,R.raw.starttune);
            background.start();
            int random;
            if(noq==14){
                background.stop();
                start.start();
                result();
            }
            if((noq>=3)&&(noq<6)){
                random=rn.nextInt(10) + 11;
                level1.setText("Level=2");
                cashlock.setText("Cashlock=$2000");
            level++;}
            else if((noq>=6)&&(noq<9)){
                random=rn.nextInt(10) + 21;
                level1.setText("Level=3");
                cashlock.setText("CashLock=$16000");
                level++;
                }
            else if((noq>=9)&&(noq<12)){
                random=rn.nextInt(10) + 31;
                level1.setText("Level=4");
                cashlock.setText("CashLock=$128000");
            level++;}
            else if((noq>=12)&&(noq<=14)){
                random=rn.nextInt(10) + 41;
                level1.setText("Level=5");
                cashlock.setText("CashLock=$1024000");
            level++;}
            else
                random=rn.nextInt(10) + 1;
            do{
                if(repeatchecker(random)){
                    if((noq>=3)&&(noq<6))
                        random=rn.nextInt(10) + 11;
                    else if((noq>=6)&&(noq<9))
                        random=rn.nextInt(10) + 21;
                    else if((noq>=9)&&(noq<12))
                        random=rn.nextInt(10) + 31;
                    else if((noq>=12)&&(noq<=14))
                        random=rn.nextInt(10) + 41;
                    else
                        random=rn.nextInt(10) + 1;
                }
            }while (repeatchecker(random));
            this.a[noq]=random;
            switch (random)
            {
                case 1:
                    q="What difference does the 5th generation computer have from other generation computers?";
                    oa="Technological advancement";
                    ob="Scientific code";
                    oc="Object Oriented Programming";
                    od="All of the above";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Technological advancement";
                    break;
                case 2:
                    q="Which of the following computer language is used for artificial intelligence?";
                    oa="FORTRAN";
                    ob="PROLOG";
                    oc="C";
                    od="D";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="PROLOG";
                    break;
                case 3:
                    q="A computer program that converts assembly language to machine language is";
                    oa="Compiler";
                    ob="Interpreter";
                    oc="Assembler";
                    od="Comparator";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Assembler";
                    break;
                case 4:
                    q="The section of the CPU that selects, interprets and sees to the execution of program instructions";
                    oa="Memory";
                    ob="Register unit";
                    oc="Control unit";
                    od="ALU";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Control unit";
                    break;
                case 5:
                    q="A common boundary between two systems is called";
                    oa="Interdiction";
                    ob="Interface";
                    oc="Surface";
                    od="None of the above";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Interface";
                    break;
                case 6:
                    q="Which output device is used for translating information from a computer into pictorial form on paper";
                    oa="Mouse";
                    ob="Plotter";
                    oc="Touch panel";
                    od="Card punch";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Plotter";
                    break;
                case 7:
                    q="The first generation of computers available was based on the bit micro processors";
                    oa="4";
                    ob="8";
                    oc="16";
                    od="64";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="8";
                    break;
                case 8:
                    q="Compilers and interpreters are themselves";
                    oa="High-level language";
                    ob="Codes";
                    oc="Programs";
                    od="Mnemonics";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Programs";
                    break;
                case 9:
                    q="A memory that holds micro programs is";
                    oa="Core memory";
                    ob="ROM";
                    oc="RAM";
                    od="Control memory";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="ROM";
                    break;
                case 10:
                    q="Which of the following is the coding of data so that is can't be easily understood if intercepted";
                    oa="Barcode";
                    ob="Decoder";
                    oc="Encryption";
                    od="Mnemonics";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Encryption";
                    break;
                case 11:
                    q="Human beings are referred to as Homosapiens. Which device is called Silico sapiens?";
                    oa="Monitor";
                    ob="Hardware";
                    oc="Robot";
                    od="Computer";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Computer";
                    break;
                case 12:
                    q="The arranging of data in a logical sequence is called:";
                    oa="sorting";
                    ob="classifying";
                    oc="reproducing";
                    od="summarizing";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="sorting";
                    break;
                case 13:
                    q="Who is the creator of the PASCAL language?";
                    oa="Niklaus Wirth";
                    ob="Dijkstra";
                    oc="Donald Knuth";
                    od="Basic Pascal";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Niklaus Wirth";
                    break;
                case 14:
                    q="The storage locations in the internal storage of a CPU are called";
                    oa="contents";
                    ob="addresses";
                    oc="locations";
                    od="mask";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="addresses";
                    break;
                case 15 :
                    q="Can you tell what passes into and out from the computer via its ports?";
                    oa="Data";
                    ob="Bytes";
                    oc="Graphics";
                    od="Pictures";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Bytes";
                    break;
                case 16:
                    q="In a computer system, which device is functionally opposite of a Key-board?";
                    oa="Mouse";
                    ob="Trackball";
                    oc="Printer";
                    od="Joystick";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Printer";
                    break;
                case 17:
                    q="The CPU chip used in a computer is partially made out of:";
                    oa="Copper";
                    ob="Iron";
                    oc="Gold and silver";
                    od="Silica";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Silica";
                    break;
                case 18:
                    q="The general range of speed in revolutions per minute (rpm) at which floppy disks rotate is";
                    oa="2400-4700";
                    ob="390-600";
                    oc="150-250";
                    od="300-600";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="150-250";
                    break;
                case 19:
                    q="Personal computers use a number of chips mounted on a main circuit board. What is the common name for such boards?";
                    oa="Daughterboard";
                    ob="Motherboard";
                    oc="Fatherboard";
                    od="Breadboard";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Motherboard";
                    break;
                case 20:
                    q="A half byte is know is";
                    oa="Data";
                    ob="Bit";
                    oc="Half byte";
                    od="Nibble";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Nibble";
                    break;
                case 21:
                    q="A step-by-step procedure used to solve a problem is called";
                    oa="Operating system";
                    ob="Algorithm";
                    oc="Application program";
                    od="All of the above";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Algorithm";
                    break;
                case 22:
                    q="The personnel which deal with the computer and its management put together is known as";
                    oa="Firm ware";
                    ob="Human ware";
                    oc="Software";
                    od="Hardware";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Human ware";
                    break;
                case 23:
                    q="Which of the following terms describe 1024 kilobytes?";
                    oa="Kilobyte";
                    ob="Megabyte";
                    oc="Gigabyte";
                    od="Terabyte";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Megabyte";
                    break;
                case 24:
                    q="An error in computer data is called";
                    oa="Chip";
                    ob="Bug";
                    oc="CPU";
                    od="Storage devices";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Bug";
                    break;
                case 25:
                    q="Which is a Common-Business oriented language.";
                    oa="SNOBOL";
                    ob="BASIC";
                    oc="COBOL";
                    od="C";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="COBOL";
                    break;
                case 26:
                    q="MODULA is a";
                    oa="Programming language";
                    ob="Low-level language";
                    oc="Assembly language";
                    od="Machine language";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Programming language";
                    break;
                case 27:
                    q="Which memory is nonvolatile and may be written only once?";
                    oa="RAM";
                    ob="EE-ROM";
                    oc="RAM";
                    od="PROM";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="PROM";
                    break;
                case 28:
                    q="What is the alternative name for a diskette?";
                    oa="Floppy disk";
                    ob="Hard disk";
                    oc="Flexible disk";
                    od="Winchester disk";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Floppy disk";
                    break;
                case 29:
                    q="Instruction in computer languages consists of...";
                    oa="OPCODE";
                    ob="OPERAND";
                    oc="Syntax";
                    od="None of These";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Syntax";
                    break;
                case 30:
                    q="The most frequently used instructions of a computer program are likely to be fetched from:";
                    oa="RAM";
                    ob="cache memory";
                    oc="the hard disk";
                    od="registers";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="cache memory";
                    break;
                case 31:
                    q="VGA is";
                    oa="Video Graphics Array";
                    ob="Visual Graphics Array";
                    oc="Volatile Graphics Array";
                    od="none";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Video Graphics Array";
                    break;
                case 32:
                    q="WAN stands for";
                    oa="Wrap Area Network";
                    ob="Wide Area Network";
                    oc="Wide Array Net";
                    od="Wireless Area Network";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Wide Area Network";
                    break;
                case 33:
                    q="Ctrl, Shift and Alt are called __ keys.";
                    oa="function";
                    ob="modifier";
                    oc="adjustment";
                    od="alphanumeric";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="modifier";
                    break;
                case 34:
                    q="Correcting errors in a program is referred to as";
                    oa="Debugging";
                    ob="bugging";
                    oc="Rectifying";
                    od="modifying";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Debugging";
                    break;
                case 35:
                    q="Using windows Explorer, a plus(+) sign in front of a folder indicates----";
                    oa="an open folder";
                    ob="the folder contains subfolder";
                    oc="the text file";
                    od="the media file";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="the folder contains subfolder";
                    break;
                case 36:
                    q="During the boot process, the ---- looks for the system files.";
                    oa="CD";
                    ob="BIOS";
                    oc="CPU";
                    od="DVD";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="BIOS";
                    break;
                case 37:
                    q="What is the smallest and largest font size available in Font Size tool on formatting toolbar?";
                    oa="8 and 72";
                    ob="8 and 68";
                    oc="6 and 72";
                    od="6 and 68";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="8 and 72";
                    break;
                case 38:
                    q="A hard disk is divided into tracks which are further subdivided into:";
                    oa="clusters";
                    ob="sectors";
                    oc="vectors";
                    od="heads";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="sectors";
                    break;
                case 39:
                    q="Information in a memory that is no longer valid or wanted is known as";
                    oa="non-volatile";
                    ob="volatile";
                    oc="surplus";
                    od="garbage";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="garbage";
                    break;
                case 40:
                    q="Access time is the highest in the case of";
                    oa="floppy disk";
                    ob="cache";
                    oc="swapping devices";
                    od="magnetic disk";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="magnetic disk";
                    break;
                case 41:
                    q="The most common systems security method is";
                    oa="passwords";
                    ob="encryption";
                    oc="firewall";
                    od="all of the above";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="passwords";
                    break;
                case 42:
                    q="Which of the following is not applications software?";
                    oa="Word processing";
                    ob="Spreadsheet";
                    oc="UNIX";
                    od="Desktop publishing";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="UNIX";
                    break;
                case 43:
                    q="The errors that can be pointed out by the compiler are";
                    oa="Syntax errors";
                    ob="Semantic errors";
                    oc="Logical errors";
                    od="Internal errors";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Syntax errors";
                    break;
                case 44:
                    q="Which of the following instruction steps, would be written within the diamond-shaped box, of a flowchart?";
                    oa="S = B - C";
                    ob="IS A<10";
                    oc="PRINT A";
                    od="DATA X,4Z";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="IS A<10";
                    break;
                case 45:
                    q="The working principles of today's computers were provided by an English mathematician";
                    oa="Charles Babbage";
                    ob="Dr. Hollerith";
                    oc="Donald Reach";
                    od="Ken Reider";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Charles Babbage";
                    break;
                case 46:
                    q="The CPU is made up of control unit ALU and";
                    oa="Memory";
                    ob="Input-Output";
                    oc="Register unit";
                    od="All of the above";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="Memory";
                    break;
                case 47:
                    q="The OR, XOR & AND functions can be performed by _____ of the computer in a CPU.";
                    oa="ALU";
                    ob="CU";
                    oc="Memory";
                    od="Register";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="ALU";
                    break;
                case 48:
                    q="The output of a 2 input OR gate is 0 only when its";
                    oa="both inputs are 0";
                    ob="either input is 1";
                    oc="both inputs are 1";
                    od="either input is 0";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="both inputs are 0";
                    break;
                case 49:
                    q="The term gigabyte refers to";
                    oa="1024 bytes";
                    ob="1024 kilobytes";
                    oc="1024 megabytes";
                    od="1024 terabytes";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="1024 megabytes";
                    break;
                case 50:
                    q="The operation of a digital computer is based on _____ principle.";
                    oa="counting";
                    ob="measuring";
                    oc="electronic";
                    od="logical";
                    questions.setText(q);
                    a.setText(oa);
                    b.setText(ob);
                    c.setText(oc);
                    d.setText(od);
                    answer="counting";
                    break;

            }
            if(noq>=10)
                tufftimer.start();
            else
                easytimer.start();
        }
        public boolean repeatchecker(int x){
            for(int i=0;i<noq;i++){
                if(a[i]==x)
                    return true;
            }
            return false;
        }
        public void result(){
            if((noq>=3)&&(noq<6))
                money=2000;
            else if((noq>=6)&&(noq<9))
                money=16000;
            else if((noq>=9)&&(noq<12))
                money=128000;
            else if((noq>=12)&&(noq<14))
                money=1024000;
            else if(noq==14)
                money=10000000;
            else
                money=0;
            background.stop();
            tufftimer.cancel();
            easytimer.cancel();
            bundle.putString("money", String.valueOf(money));
            Intent i = new Intent(this, Result.class);
            i.putExtras(bundle);
            startActivity(i);
            finish();
        }
        public void onBackPressed() {
                background.stop();
                tufftimer.cancel();
                easytimer.cancel();
                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                finish();
            }

}
