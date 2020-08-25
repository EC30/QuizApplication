package com.example.quiz_application;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import static com.example.quiz_application.Table.QuestionsTable;

public class Helper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyAwesomeQuiz.db";
    private static final int DATABASE_VERSION = 3;
    private SQLiteDatabase db;
    public Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                Table.QuestionsTable.TABLE_NAME + " ( " +
                Table.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Table.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                Table.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionsTable.COLUMN_DIFFICULTY + " TEXT" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }
    private void fillQuestionsTable() {
        Question j1= new Question("Which of the following is not a Java features?","Dynamic", "Use of pointers", "Object Oriented","Architecture Neutral", 2,Question.CATEGORY_Java);
        Question j2= new Question("Which of the following is a valid declaration of a char?","char ch = '\\utea';", "char ca = 'tea';", "char cr = \\u0223;","char cc = '\\itea';", 1,Question.CATEGORY_Java);
        Question j3= new Question("Modulus operator, %, can be applied to which of these?","Integer", "Floating and pointer number", "Both Integers and floating – point numbers","None of the above", 3,Question.CATEGORY_Java);
        Question j4= new Question("Which of the following can be operands of arithmetic operators?","Numeric", "Boolean", "Both Numeric & Characters","Characters", 3,Question.CATEGORY_Java);
        Question j5= new Question("What is the return type of the hashCode() method in the Object class?","Object", "Int", "Void","Long", 2,Question.CATEGORY_Java);
        Question j6= new Question("What does the expression float a = 35 / 0 return?","0", "Not a number", "Run time exception","Infinity", 4,Question.CATEGORY_Java);
        Question j7= new Question("Which of the following creates a List of 3 visible items and multiple selections abled?","new List(false, 3)", "new List(3, true)", "new List(true,3)","ew List(3, false)", 2,Question.CATEGORY_Java);
        Question j8= new Question("In which process, a local variable has the same name as one of the instance variables?","Variable Shadowing", "Multi-threading", "Serialization","Abstraction", 1,Question.CATEGORY_Java);
        Question j9= new Question("Which package contains the Random class?","java.util package", "java.lang package", "java.awt package","java.io package", 1,Question.CATEGORY_Java);
        Question j10= new Question("Which of the following is an immediate subclass of the Panel class?","Dialog class", "Window class", "Frame class","Applet class", 4,Question.CATEGORY_Java);
        addQuestion(j1);
        addQuestion(j2);
        addQuestion(j3);
        addQuestion(j4);
        addQuestion(j5);
        addQuestion(j6);
        addQuestion(j7);
        addQuestion(j8);
        addQuestion(j9);
        addQuestion(j10);

        Question p1= new Question("Is Python case sensitive when dealing with identifiers?","Yes", "No", "machine dependent","None of the above", 1,Question.CATEGORY_Python);
        Question p2= new Question("Which of the following is invalid?","_a = 1", " __a = 1", "__str__ = 1","None of the above", 4,Question.CATEGORY_Python);
        Question p3= new Question("Which one of these is floor division?","/", "//", "%","$", 2,Question.CATEGORY_Python);
        Question p4= new Question(" Which one of the following has the same precedence level?","Addition and Subtraction", "Multiplication, Division and Addition", " Multiplication and Division","Addition and Multiplication", 1,Question.CATEGORY_Python);
        Question p5= new Question("Which of the following formatting options can be used in order to add ‘n’ blank spaces after a given string ‘S’?","print(“-ns”%S)", "print(“-ns”%S)", "print(“%ns”%S)","print(“%-ns”%S)", 4,Question.CATEGORY_Python);
        Question p6= new Question(" Which of the following commands will create a list?","list1 = list()", "list1 = []", " list1 = list([1, 2, 3])","All of the mentioned", 4,Question.CATEGORY_Python);
        Question p7= new Question("To shuffle the list(say list1) what function do we use?"," list1.shuffle()", "shuffle(list1)", "random.shuffle(list1)","random.shuffleList(list1)", 3,Question.CATEGORY_Python);
        Question p8= new Question("Suppose list1 is [2, 33, 222, 14, 25], What is list1[-1]?","25", "2", "Error","None", 1,Question.CATEGORY_Python);
        Question p9= new Question("What is the type of each element in sys.argv?","Set", "List", "Tuple","String", 4,Question.CATEGORY_Python);
        Question p10= new Question("How many keyword arguments can be passed to a function in a single function call?","one", "Zero or more", "One or more","Two", 2,Question.CATEGORY_Python);
        addQuestion(p1);
        addQuestion(p2);
        addQuestion(p3);
        addQuestion(p4);
        addQuestion(p5);
        addQuestion(p6);
        addQuestion(p7);
        addQuestion(p8);
        addQuestion(p9);
        addQuestion(p10);

        Question h1= new Question("What should be the correct syntax to write a PHP code?","< php >", "<?php >", "<? ?>","<?php ?>", 3,Question.CATEGORY_PHP);
        Question h2= new Question("Which of the following must be installed on your computer so as to run PHP script?","XAMPP", "Apache and PHP", "IIS","All of the above", 4,Question.CATEGORY_PHP);
        Question h3= new Question("Type Hinting was introduced in which version of PHP?","PHP 4", "PHP 5", "PHP 5.3","PHP 6", 2,Question.CATEGORY_PHP);
        Question h4= new Question("A function in PHP which starts with __ (double underscore) is known as?","Magic Function", "Inbuilt Function", "Default Function","User Defined Function", 1,Question.CATEGORY_PHP);
        Question h5= new Question("How many types of filtering are present in PHP?","3", "2", "4","None of the above", 2,Question.CATEGORY_PHP);
        Question h6= new Question("Which one of the following filter is used to filter several variables with the same or different filters?","filter_var_array()", "filter_var()", "filter_input","filter_input_array", 1,Question.CATEGORY_PHP);
        Question h7= new Question("The filesize() function returns the file size in ","Bits", "Bytes", "kilobytes","Gigabytes", 2,Question.CATEGORY_PHP);
        Question h8= new Question("Which method is simply an object-oriented version of date()?","DateTime::format()", "DateTime::modify()", "DateTime::setTime()","DateTime::setDate()", 1,Question.CATEGORY_PHP);
        Question h9= new Question("Which of the following advanced OOP features is/are not supported by PHP?","Method overloading", "Multiple Inheritance", "Both a and b","Object Cloning", 3,Question.CATEGORY_PHP);
        Question h10= new Question("Which one of the following PHP function is used to determine a file’s last access time?","fileltime()", "filectime()", "fileatime()","filetime()", 3,Question.CATEGORY_PHP);
        addQuestion(h1);
        addQuestion(h2);
        addQuestion(h3);
        addQuestion(h4);
        addQuestion(h5);
        addQuestion(h6);
        addQuestion(h7);
        addQuestion(h8);
        addQuestion(h9);
        addQuestion(h10);

        Question s1= new Question("What is the full form of SQL?","Structural Query language", "Simple Query language", "Simple Query List","Sructural Qiery List", 1,Question.CATEGORY_SQL);
        Question s2= new Question("Which SQL function is used to count the number of rows in a SQL query?","SUM()", "NUMBER()", "COUNT()","None of the above", 3,Question.CATEGORY_SQL);
        Question s3= new Question("Which of the following is not a valid SQL type?","Decimal", "Numeric", "Float","Character", 1,Question.CATEGORY_SQL);
        Question s4= new Question("The database language that allows us to access data in a database is called :","DML", "DCL", "DDL","None of the above", 2,Question.CATEGORY_SQL);
        Question s5= new Question("Which of the following is a comparison operator in SQL?","Double equal sign ( == )", "LIKE", "BETWEEN","Single equal sign ( = )", 1,Question.CATEGORY_SQL);
        Question s6= new Question("Which command is used to change the table storage Characteristics?","CHANGE TABLE", "ALTER TABLE", "UPDATE TABLE","MODIFY TABLE", 2,Question.CATEGORY_SQL);
        Question s7= new Question("Which data type can store unstructured data in a column?","NUMERIC", "VARCHAR", "CHAR","RAW", 4,Question.CATEGORY_SQL);
        Question s8= new Question("Which function is used to divides one numeric expression by another and get the remainder ?","POWER", "MOD", "ROUND","REMINDER", 2,Question.CATEGORY_SQL);
        Question s9= new Question("The virtual table that its created by data from the result of an SQL 'Select' statement is called","Synonym", "Transaction", "View","Sequence", 3,Question.CATEGORY_SQL);
        Question s10= new Question("Which of the following are TCL commands?","UPDATE and TRUNCATE", "SELECT and INSERT", "GRANT and REVOKE","ROLLBACK and SAVEPOINT", 4,Question.CATEGORY_SQL);
        addQuestion(s1);
        addQuestion(s2);
        addQuestion(s3);
        addQuestion(s4);
        addQuestion(s5);
        addQuestion(s6);
        addQuestion(s7);
        addQuestion(s8);
        addQuestion(s9);
        addQuestion(s10);

        Question q1= new Question("Which of the following jQuery method sets attributes of an element?"," attr(name, value)", " setAttr(name, value)", " setAttributes(name, value)","None of the above", 1,Question.CATEGORY_JQUERY);
        Question q2= new Question("Which of the following jQuery method gets a set of elements containing all of the unique siblings of each of the matched set of elements?","parents( selector)", "prevAll( selector)", "siblings( selector)","offAll(selector)", 3,Question.CATEGORY_JQUERY);
        Question q3= new Question("Which sign jQuery use as a shortcut of jQuery?","the % sign", "the $ sign", "the ? sign","None of the above", 2,Question.CATEGORY_JQUERY);
        Question q4= new Question("Which built-in method returns the character at the specified index?","characterAt()", "getCharAt()", "charAt()","None of the above", 3,Question.CATEGORY_JQUERY);
        Question q5= new Question("JQuery is a","JavaScript library", "JavaScript language", "JavaScript Method","PHP Method", 1,Question.CATEGORY_JQUERY);
        Question q6= new Question("Which jQuery method is use to hide selected element?","hidden()", "hide()", "visible(false)","display(false)", 2,Question.CATEGORY_JQUERY);
        Question q7= new Question("Which built-in method returns the string representation of the number's value?","toString()", "toNumber()", "toInteger()","tovalue()", 1,Question.CATEGORY_JQUERY);
        Question q8= new Question("Which scripted language is jQuery written in?","VBscript", "C++", "C#","JavaScript", 4,Question.CATEGORY_JQUERY);
        Question q9= new Question("Which of the following jQuery method removes elements matching the specified selector from the set of matched elements?","getNotEquals( selector )", "isNotEquals( selector )", "not( selector )","None of the above", 3,Question.CATEGORY_JQUERY);
        Question q10= new Question("Which method should deal with name conflict ?","noNameConflict()", "nameConflict()", "noConflict()","Conflict()", 4,Question.CATEGORY_JQUERY);
        addQuestion(q1);
        addQuestion(q2);
        addQuestion(q3);
        addQuestion(q4);
        addQuestion(q5);
        addQuestion(q6);
        addQuestion(q7);
        addQuestion(q8);
        addQuestion(q9);
        addQuestion(q10);

        Question m1= new Question("C++ does not supports the following","Multilevel inheritance", "Hierarchical inheritance", "Hybrid inheritance","Supports all inheritance", 4,Question.CATEGORY_HTML);
        Question m2= new Question("How many number of arguments can a destructor of a class receives?","0", "-1", "-2","-3", 1,Question.CATEGORY_HTML);
        Question m3= new Question("Which of the following is a correct identifier in C++?","7var_name", "7VARNAME", "VAR_1234","$var_name", 3,Question.CATEGORY_HTML);
        Question m4= new Question("Which of the following is called address operator?","+", "&", "*","-", 2,Question.CATEGORY_HTML);
        Question m5= new Question("Which function is used to read a single character from the console in C++?","cin.get(ch)", " getline(ch)", "read(ch)","scanf(ch)", 1,Question.CATEGORY_HTML);
        Question m6= new Question("Which of the following is correct?","C++ allows static type checking", "C++ allows dynamic type checking", "C++ allows static member function to be of type const"," C++ allows both static and dynamic type checking", 4,Question.CATEGORY_HTML);
        Question m7= new Question("Which operator is having the highest precedence in c++?","postfix", "Equality", "Unary","Shift", 1,Question.CATEGORY_HTML);
        Question m8= new Question(" Which of the following cannot be used with the virtual keyword?","Class", "Member function", "constructors","Destructors", 3,Question.CATEGORY_HTML);
        Question m9= new Question("What is this operator called ?:?","Conditional", "Relational", "Casting operator","Unrelational", 1,Question.CATEGORY_HTML);
        Question m10= new Question("The if..else statement can be replaced by which operator?","Bitwise operator", "Conditional operator", "Multiplicative operator","Addition operator", 2,Question.CATEGORY_HTML);
        addQuestion(m1);
        addQuestion(m2);
        addQuestion(m3);
        addQuestion(m4);
        addQuestion(m5);
        addQuestion(m6);
        addQuestion(m7);
        addQuestion(m8);
        addQuestion(m9);
        addQuestion(m10);


    }
    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_DIFFICULTY, question.getDifficulty());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }
    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
    public ArrayList<Question> getQuestions(String difficulty) {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        String[] selectionArgs = new String[]{difficulty};
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME +
                " WHERE " + QuestionsTable.COLUMN_DIFFICULTY + " = ?", selectionArgs);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}
