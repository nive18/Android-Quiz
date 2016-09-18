package theri.baby.geoquiz15;

public class Question {
private int ID;
private String Question;
private String OPTA;
private String OPTB;
private String OPTC;
private String Answer;
public Question()
{
ID=0;
Question="";
OPTA="";
OPTB="";
OPTC="";
Answer="";
}
public Question(String qUestion,String optA,String optB,String optC,String aNSWER)
{
Question=qUestion;
OPTA=optA;
OPTB=optB;
OPTC=optC;
Answer=aNSWER;

}
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public String getQuestion() {
	return Question;
}
public void setQuestion(String question) {
	Question = question;
}
public String getOPTA() {
	return OPTA;
}
public void setOPTA(String oPTA) {
	OPTA = oPTA;
}
public String getOPTB() {
	return OPTB;
}
public void setOPTB(String oPTB) {
	OPTB = oPTB;
}
public String getOPTC() {
	return OPTC;
}
public void setOPTC(String oPTC) {
	OPTC = oPTC;
}
public String getAnswer() {
	return Answer;
}
public void setAnswer(String answer) {
	Answer = answer;
}
}

