package theri.baby.geoquiz15;


import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DbHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "triviaQuiz";
	// tasks table name
	private static final String TABLE_QUEST = "quest";
	// tasks Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_QUES = "question";
	private static final String KEY_ANSWER = "answer"; //correct option
	private static final String KEY_OPTA= "opta"; //option a
	private static final String KEY_OPTB= "optb"; //option b
	private static final String KEY_OPTC= "optc"; //option c
	private SQLiteDatabase dbase;
	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		dbase=db;
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
				+KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
		db.execSQL(sql);
        addQuestions();
        
		
	}
	private void addQuestions()
	{
		Question q1=new Question("Which of the following phenomena cannot be observed on the"+"surface of moon?" +
				"rising of sun","Solar Eclpise","Lunar Eclipse","Twinkling of star","Twinkling of star");
		this.addQuestion(q1);
		Question q2=new Question("Which Planets looks reddish " +
				"in the night sky?", "Jupiter", "Saturn", "Mars", "Mars");
		this.addQuestion(q2);
		Question q3=new Question("Whic female astronaut spent maximum" +
				" time in space?","Kalpana Chawla", "Sunita Williams","Lisa Norwak","Sunita Williams");
		this.addQuestion(q3);
		Question q4=new Question("Which planet has fastest" +
				" revolutin time?",	"Mercury", "Mars", "Earth","Mercury");
		this.addQuestion(q4);
		Question q5=new Question("Black hole" +
				" is?","Dark Hollow","Collapsing star","Other side of moon","Collapsing star");
		this.addQuestion(q5);
		Question q6=new Question("Smallest Ocean in " +
				" the world?","Antartic Ocean","Artic Ocean","Indian Ocean","Arctic Ocean");
		this.addQuestion(q6);
		Question q7=new Question("Largest" +
				" Desert?","Sahara Desert","Thar Desert","Gobi Desert","Sahara Desert");
		this.addQuestion(q7);
		Question q8=new Question("River with greatest" +
				" water flow?","Nile","Amazon","Zambesi","Amazon");
		this.addQuestion(q8);
		Question q9=new Question("Largest Island" +
				" is?","GreenLand","Indonesia","Honshu","GreenLand");
		this.addQuestion(q9);
		Question q10=new Question("Largest satellite of " +
				" our solar system?","Moon","Ganymede","Phobos","Ganymede");
		this.addQuestion(q10);
		Question q11=new Question("Brightest star as seen" +
				" from Earth?","Orion","Eta Carinae","Sirius","Sirius");
		this.addQuestion(q11);
		Question q12=new Question("Largest active Volcano" +
				" is?","Etna","Stromboli","Mauna Loa","Mouna Loa");
		this.addQuestion(q12);
		Question q13=new Question("Nmae of the galaxy in which" +
				" earth is planet is?","Andromeda","Milky Way","Ursa Major","Milky Way");
		this.addQuestion(q13);
		Question q14=new Question("Which of the following" +
				" is not gas planet?","Mars","Venus","Jupiter","Venus");
		this.addQuestion(q14);
		Question q15=new Question("How old is the solar " +
				"system is?","50 billion years","5 billion years","500 billion years","5 billion years");
		this.addQuestion(q15);
		
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
		// Create tables again
		onCreate(db);
	}
	// Adding new question
	public void addQuestion(Question quest) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQuestion()); 
		values.put(KEY_ANSWER, quest.getAnswer());
		values.put(KEY_OPTA, quest.getOPTA());
		values.put(KEY_OPTB, quest.getOPTB());
		values.put(KEY_OPTC, quest.getOPTC());
		// Inserting Row
		dbase.insert(TABLE_QUEST, null, values);		
	}
	public List<Question> getAllQuestions() {
		List<Question> quesList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setID(cursor.getInt(0));
				quest.setQuestion(cursor.getString(1));
				quest.setAnswer(cursor.getString(2));
				quest.setOPTA(cursor.getString(3));
				quest.setOPTB(cursor.getString(4));
				quest.setOPTC(cursor.getString(5));
				quesList.add(quest);
			} while (cursor.moveToNext());
		}
		// return quest list
		return quesList;
	}
	public int rowcount()
	{
		int row=0;
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		row=cursor.getCount();
		return row;
	}
}
