package ke;

public class valueOf {

	public valueOf() {
		// TODO Auto-generated constructor stub
	}
	public static void valueOf(String subj, String obj)
	{
		// IEEE is a style
		// 즉 이 말은 IEEE라는 것이 style의 한 종류라는 구조적 지식이다.
		// 즉,이 말은 IEEE는 ref클래스의 style property분류에 의해 IEEE라는 것을 가진다.
		// 분류를 위해서는 모델과 실제 값을 가지는데, IEEE이라는 개념은 그것들의 개체들을 모아 놓은 것이 외연이고, 그것들을 분류할 수 있는 모델이 내포인 것이다.
		// 여기서, 분류기는 IEEE와 그렇지 않은 것으로 분류(binary-class)할 수도 있고, 여러 범주들로 분류(multi-class)할 수도 있다.
		// style classification을 해서 IEEE모델을 만들고,
		// is_a 관계는 is_classified_from 와 동치이고 classify와 역의 관계이다.
		// IEEE is_a Style = IEEE is_classified_from Style <> Style classify IEEE
		
		
		// Chicago is a style
		// style classification을 해서 Chicago 모델을 만들어라.
		
		String trainData = "example4/train.dat"; // 분류하기 위한 학습데이터
		String modelName = "example4/model"; // 분류 모델
		Ref aRef = new Ref();
		// 스타일 분류를 하기 전에 
		// 선결조건이 필요하다. 어떤 선결조건인가? 아래 코드 부분, svm_multiclass를 이용한 학습 및 분류,을 그래프로 만들어야 하나? 그렇다.
		// 왜냐하면, 만든 그래프로부터 traverse하면서 아래 코드를 만들어야 하기 때문이다. 아래 코드에서 필요한 키워드들은 그래프에서 명시되든지
		// 혹은 지식베이스로부터 가져와야 한다.
		// svm_multiclass_learn -c 5000 example4/train.dat example4/model
		// svm_multiclass_classify example4/test.dat example4/model
		// example4/predictions

		// classifier_by_style은 무엇인가? 왜 필요한가? modelName과 같은 것 아닌가? modelName은
		// 모델자체일 수도 있지만, 여기서는 모델이 위치한 경로일 수 있다.
		// 1) 모델자체이면 DB에 blob형태로 저장되어 있어야 하고, 2) 만약 모델이 위치한 경로라면 server 내의 파일
		// URL일 것이다.
		if (InfoExtract_Style.classifier_by_style==null) {
			; // learn을 할지 말지는 style에 따라 분류할 model이 준비되어 있느냐 없느냐이다.
				// 만약 없다면 learn해서 그 모델을 만들고, 있다면 그 model을 가지고 입력자료를 분류한다.
		// 따라서, 그 모델은 learn에서의 모델이다.
		// 여기서 분류나 learn은 실제로 문제를 푸는 것이고, 구조적인(틀에 해당하는) 부분은 또 따로 그래프를 형성해야 한다.
		Classifier.learn(trainData, InfoExtract_Style.classifier_by_style); // 지식베이스로부터
																			// 가져온다.
																			// svm_multiclass_learn
																			// -c
																			// 1.0
																			// example_file
		}															// model_file

		// trainData는 입력인자에 해당하고, modelName은 출력인자에 해당한다.
		// trainData를 어떤 식으로 정의할 것인가? 데이터 자체라면 trainData에 대한 클래스가 정의되어 있어야 하겠고
		// 그렇지 않고 경로라면 trainData가 정의된 파일 URL일 것이다. 이것은 어떻게 알 수 있나?
		// modelName은 어떤 식으로 처리할 지 고민해야 한다. 즉, 없었다가 만들어지기 때문에 서버나 로컬에
		// 만든 후에는 1) 만든 곳의 URL이나 혹은 2)그 자체로 blob형태로 DB에 저장해야 한다.
		Classifier.classify(aRef.text, InfoExtract_Style.classifier_by_style, aRef.refValue); // 지식베이스로부터
																			// 가져온다.
																			// classify한
																			// 다음에는
																			// 그
																			// style이
																			// 결정된다.
	
		
	}
	public static void main(String[] args)
	{
		valueOf("IEEE", "Style");
	}

}
