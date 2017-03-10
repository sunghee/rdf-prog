public class InfoExtract_Style
{ 
	public InfoExtract_Style() {
	} 
	String classifier_by_style;
	public void InfoExtract_Style(Ref aRef, CRFmodel aCRFmodel) {
 		if (classifier_by_style == "")
 			Classifier.learn(traindata, modelname);
 		Classifier.classify(aRef, modelname);
		InfoExtract( aRef,  aCRFmodel.key(aRef.style));
	} 
	public static void main(String[] args) {
		InfoExtract_Style aThisClass = new InfoExtract_Style();
		aThisClass.InfoExtract_Style( aRef,  aCRFmodel);
}
