package cos.main;
import cos.UI.*;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

import cos.vo.Cosmetic;
import cos.service.*;
import cos.util.AssortDouble;
import cos.util.AssortInt;
public class test {

	public static void main(String[] args) {

		Cosmetic cosAdd[][] = new Cosmetic[3][30];
		CosDAO dao = new CosDAO();
try {}		
		
finally {
		//< 건성용 화장품 리스트 >
cosAdd[0][0] =new Cosmetic( "헤라 아쿠아볼릭 에센셜 에멀젼" , 29720 , "헤라" , "깊은 보습과 영양성분으로 피부를  부드럽게 보호해주는 촉촉한 로션" , "건성" , "로션");

cosAdd[0][1] =new Cosmetic( "오휘 포맨 하이드라 로션" , 28000 , "오휘" , "피부가 당기거나 버석거리는 등  건조함을 방지, 유분과 수분을 규형있게 공급하여 상쾌하면서도 깔끔한 피부로!" , "건성" , "로션");

cosAdd[0][2] =new Cosmetic( "로즈워터 토너" , 10500 , "마몽드" , "물 대신, 장미수 90.89% 함유로 촉촉하게 닦아내는 진정보습 장미수 토너" , "건성" , "스킨");

cosAdd[0][3] =new Cosmetic( "쌀 진액 스킨" , 25900 , "한율" , "깨끗한 물과 양분을 품은 여주 쌀을 발효하여 만든 진액으로 건조한 피부에 수분을 채우고 잡아두는 진한 보습 스킨" , "건성" , "스킨");

cosAdd[0][4] =new Cosmetic( "모이스트젠 소프너 스킨" , 23100 , "아이오페" , "피부 깊이 촉촉함을 선사하여 건조로 인한 피부 당김을 해소해주는 보습스킨" , "건성" , "스킨");

cosAdd[0][5] =new Cosmetic("아르간 오일 울트라 딥 모이스춰 로션" , 16000 , "해피바스" , "무농약 아르간 오일과 검은콩 발효 천연보습인자가 수분을 채워주고 잡아주는 당김 완화 수분 랩핑 보습" , "건성" , "로션" );

cosAdd[0][4] =new Cosmetic("시어버터 인텐시브 모이스춰 로션" , 16000 , "해피바스" , "시어버터와 검은콩 발효 천연보습인자가 피부 깊숙이 수분을 채워주고 잡아주는 24시간 수분 랩핑 보습" , "건성", "로션");

cosAdd[0][6] =new Cosmetic("울트라 리페어 모이스춰 크림" , 7500 , "일리윤" , "고함량 판테놀(5%) 함유, 건조로 인한 당김, 가려움, 거칠어짐을 집중 케어하여 하루 종일 촉촉하고 편안한 피부로 가꿔주는 초고보습 크림" , "건성" , "로션");

cosAdd[0][7] =new Cosmetic("세라마이드 아토 집중크림 " , 9950 , "일리윤" , "민감하고 건조한 피부에 보습/진정 효과를 주는 피부 장벽 강화 저자극 크림", "건성" , "로션" );

cosAdd[0][8] =new Cosmetic( "울트라 리페어 로션" , 9950 , "일리윤" , "건조하고 거칠어진 손상 피부에 당김 없는 편안함을 주는 고밀착 고보습 로션" , "건성", "로션");

cosAdd[0][9] =new Cosmetic("울트라 리페어 크림" , 9950 , "일리윤" , "건조하고 거칠어진 손상 피부를 집중 케어하는 고밀착 초고보습 크림" , "건성" , "로션");

cosAdd[0][10] =new Cosmetic( "모이스처 세라마이드 크림 홀리데이 에디션" , 20300 , "마몽드" , "빈틈없는 밀착 보습으로 튼튼한 피부 장벽을 만들어 주는 무궁화 보습 장벽 크림 (홀리데이 한정판 패키지)" , "건성" , "로션");

cosAdd[0][11] =new Cosmetic("더마 마일드 미셀라 워터" , 9800 ,"일리윤" , "물 세안이 필요 없는 약산성 저자극 클렌징워터" , "건성" , "스킨" );

cosAdd[0][12] =new Cosmetic("쌀 진액 보습크림" , 28000 , "한율" , "쌀의 진한 보습 성분이 메마른 피부 겹겹이 보습막을 더하여 윤기 흐르는 물찬 피부를 완성하는 진한 보습 크림" , "건성" , "로션" );

cosAdd[0][13] =new Cosmetic("인리치드 뉴트리 스킨소프너" , 11200 , "마몽드" , "건조하고 메마른 피부를 건강하고 촉촉하게 가꿔주는 고영양 스킨" , "건성" , "스킨" );
//
cosAdd[0][14] =new Cosmetic("갈색솔잎 율려원액" , 38500 , "한율" , "자연 안티에이징 원료 갈색솔잎의 힘으로 투명한 어린 피부를 되찾아주는 고수분 안티에이징 세럼" , "건성" , "로션" );

cosAdd[0][15] =new Cosmetic("바이오 나이트 마스크 인텐시브 리차징" , 35000 , "아이오페" , "낮 동안 지치고 손상된 피부 에너지를 밤 시간 동안 재충전 시 켜주는 나이트 마스크" , "건성" , "로션" );

cosAdd[0][16] =new Cosmetic("퍼펙트 리뉴 에멀젼" , 28000 , "라네즈" , "유수분 균형을 맞추고 피부를 보호해주는 에멀젼" , "건성" , "로션" );

cosAdd[0][17] =new Cosmetic("퍼펙트 리뉴 크림" , 42000 , "라네즈" , "피부 장벽을 강화하고 생기있게 가꾸는 고보습 크림" , "건성" , "로션" );

cosAdd[0][18] =new Cosmetic("퓨어화이트 울트라액티브 크림" , 24500 , "마몽드" , "탄력미백막이 피부를 보호하여 세월에 따라 가속화되는 피부 칙칙함과 탄력저하를 방어해주는 탄력미백크림" , "건성" , "로션" );

cosAdd[0][19] =new Cosmetic("라이브 리프트 소프너" , 24500 , "아이오페" , "피부결을 부드럽게 정돈해주며 촘촘하고 매끄러운 피부로 안티에이징 탄력 소프너" , "건성" , "스킨" );

cosAdd[0][20] =new Cosmetic("크리미 모이스춰라이저 딥 모이스트" , 34000 , "빌리프" , "부드럽게 밀착되어 풍부한 영양감과 함께 촉촉함을 선사하는 건성 피부용 모이스춰라이저" , "건성" , "로션");

cosAdd[0][21] =new Cosmetic("RNA 파워 래디컬 뉴 에이지 크림" ,125000 ,"에스케이투" , "상하로 끊임없이 탄력을 끌어올려주어, 피부의 빈틈을 채워주는 탄력 크림" , "건성" ,"로션" );

cosAdd[0][22] =new Cosmetic("페이셜 트리트먼트 클리어 로션" , 61000 , "에스케이투" , "오래된 각직이나, 모공에 남은 더러움을 온화하게 제거해, 투명감이 있는 피부를 유지시켜 줍니다." , "건성" , "로션" );

cosAdd[0][23] =new Cosmetic("랑콤 블랑 엑스퍼트 무스 인 로션" , 64000 , "랑콤" , "무스가 머금은 수분 브라이트닝 성분이 피부에 바르는 순간 물로 변하면서 피부 속 흡수와 함께 피부층에 수분을 꽉 잡아줍니다." , "건성" , "로션" );

cosAdd[0][24] =new Cosmetic("리-뉴트리브 인텐시브 소프트닝 로션" , 58000 , "에스티로더" , "금가루 입자가 포함되어 피부를 닦아내고 매끄럽게 정돈시켜주며, 유수분 밸런스를 찾아주는 무알코올 로션" , "건성" , "로션" );
cosAdd[0][25] =new Cosmetic("페이셜 트리트먼트 클리어 로션" , 68000 , "에스케이투" , "오래된 각직이나, 모공에 남은 더러움을 온화하게 제거해, 투명감이 있는 피부를 유지시켜 줍니다." , "건성" , "로션" );

cosAdd[0][26] =new Cosmetic("수퍼 멀티 코렉티브 크림" , 59900 , "키엘" , "수퍼 스마트 크림만의 특별한 트리오 포뮬라인 비치 트리 추출물, 재스몬산, 히아루론 산이 피부를 더욱 탱탱하고 부드럽게 케어하는데 도움을 줍니다." , "건성" , "로션" );

cosAdd[0][27] =new Cosmetic("큐컴버 허벌 알코올 프리 토너" , 26900 , "키엘" , "오이, 카모마일 등 여러 허브 추출물을 함유하여 악건성, 건성 또는 중건성 피부에 적합한 40년 전통의 알코올 프리 수분 토너입니다. 피부를 건조하게 하지 않으며 진정 효과 및 상쾌한 토닝 효과를 줍니다." , "건성" ,"스킨" );

cosAdd[0][28] =new Cosmetic("스템파워 리치 크림" , 113000 , "에스케이투" , "메마른 피부 건조함을 해결하고 윤기를 주며, 무너진 얼굴선을 잡아주는 리치하고 풍부한 질감의 크림입니다." , "건성" , "로션" );

cosAdd[0][29] =new Cosmetic("설화수 자음유액" , 44000 , "설화수" , "말끔히 흡수되어 피부를 부드럽게 다듬어주는 한방 유액" , "건성" , "로션" );


//< 중성용 화장품 리스트 >
cosAdd[1][0] =new Cosmetic( "에센셜 파워 스킨 리파이너", 19600 , "라네즈" , "빠르고 효율적인 수분 공급으로 건조한 피부를 정돈해주는 촉촉한 타입의 스킨" , "중성" , "스킨");

cosAdd[1][1] =new Cosmetic( "청순 에센스 인 오일 스킨" , 25000 , "가온도담" , "속당김을 해결하는 만능 에센스인오일 스킨", "중성", "스킨" );

cosAdd[1][2] =new Cosmetic( "플랜트 스템셀 소프너 스킨 퍼펙션" , 26600 , "아이오페" , "식물줄기세포성분과 미백보습성분이 함유된 복합 안티에이징 소프너" , "중성" , "스킨");

cosAdd[1][3] =new Cosmetic( "로맨틱 스킨 리파이너" , 18900 , "오딧세이" , "면도, 세안 후 자극 받은 피부를 부드럽게 진정시키고, 건조해진 피부에 끈적임 없이 수분을 공급해 주는 매혹적인 향취의 스킨" , "중성", "스킨");

cosAdd[1][4] =new Cosmetic( "블루 에너지 리차징 에멀전" , 21000 , "오딧세이" , "강력한 보습막이 수분증발을 케어하여 피부를 촉촉하게 유지시켜주는 리차징 에멀전" , "중성" , "로션");

cosAdd[1][5] =new Cosmetic( "오일 스무딩 로션" , 9950 , "일리윤" , "피부를 윤기있고 건강하게 가꾸어주는 동백오일 블렌딩 로션" , "중성" , "로션" );

cosAdd[1][6] =new Cosmetic("청순 페이스투토 로션" , 36000 , "가온도담" , "얼굴부터 발끝까지 온가족이 한 번에 쓰는 로션" , "중성" , "로션" );

cosAdd[1][7] =new Cosmetic("바이오 하이드로 크림" , 29400 , "아이오페" , "피부에 탄탄하게 수분을 채워주는 바이오 수분 크림" , "중성" , "로션" );

cosAdd[1][8] =new Cosmetic( "어린쑥 수분진정 플루이드" , 17500 , "한율" , "끈적임 없이 상쾌하게 수분을 전달하고 어린쑥이 피부를 편안하게 가라앉히는 마일드한 어린쑥 플루이드" , "중성" , "로션");

cosAdd[1][9] =new Cosmetic("모이스트젠 에멀젼 스킨 하이드레이션" , 24500 , "라네즈" , "피부에 수분과 영양을 공급하여 매끈한 피부로 가꿔주는 보습 로션" , "중성" , "스킨" );

cosAdd[1][10] =new Cosmetic( "서리태 새결 크림" , 35000 , "한율" , "강원도 영월의 서리태를 통째 발효해 얻은 서리태 발효 점액™과 서리태 안토시아닌의  3중 효과로(지친 피부 코팅+어린피부 케어+보습보호)건강한 어린피부를 다시  느끼게 하는 서리태 새결 크림" , "중성" , "로션");

cosAdd[1][11] =new Cosmetic( "에센셜 밸런싱 에멀젼", 21700 , "라네즈" , "매우 건조해 거칠어진 피부에 골고루 수분 밸런스를 맞춰주는 고보습 에멀젼", "중성" , "로션");

cosAdd[1][12] =new Cosmetic("모이스처 세라마이드 스킨 소프너" , 11200 , "마몽드" , "흐트러진 피부 장벽을 강화 시켜 주어 빈틈 없는 촉촉함을 제공하는 고보습 스킨" , "중성" , "스킨" );

cosAdd[1][13] =new Cosmetic("붉은 팥 필링 토너" , 17500 , "한율" , "거친 피부결을 촉촉하고 매끈하게 정돈해 주는 데일리 수분 필링 토너" , "중성" , "스킨" );

cosAdd[1][14] =new Cosmetic("타임 프리즈 인텐시브 크림" , 45500 , "라네즈" , "피부 노화의 속도를 늦추어 탄력 있고 탱탱한 어린 페이스로 가꾸는 동안 크림" , "중성" , "로션" );

cosAdd[1][15] =new Cosmetic("화이트젠 에멀젼 스킨 루미너스" , 28000 , "아이오페" , "피부를 보호하고 멜라닌을 엷게 하는 화이트닝 에멀젼" , "중성" , "스킨" );

cosAdd[1][16] =new Cosmetic("퓨어 센서티브 토너" , 9100 , "마몽드" , "피부 스트레스나 계절 변화로 지친 피부에 수분을 공급하여 진정시켜주는 민감한 피부를 위한 저자극 토너" , "중성" , "스킨");

cosAdd[1][17] =new Cosmetic("토탈 솔루션 크림" , 24500 , "마몽드" , "피부 매력을 끌어올리는 3D토탈 안티에이징 크림탄력,보습,주름, 미백,항산화까지 한번에" , "중성" , "로션" );

cosAdd[1][18] =new Cosmetic("히아루로닉 소프너" , 21000 , "아이오페" , "히아루론산이 함유되어 촉촉하고 매끈한 피부로 가꾸어 주는 보습 스킨" , "중성" , "스킨" );

cosAdd[1][19] =new Cosmetic("에이지 컨트롤 파워 크림" , 25900 , "마몽드" , "즉각적으로 탄력을 부여함과 동시에 피부 보호 장벽을 강화해주는 링클&퍼밍 2중 기능 크림" , "중성" , "스킨" );

cosAdd[1][20] =new Cosmetic("에이지 컨트롤 에멀젼" , 16800 , "마몽드" , "부드럽게 펴지며 보습막을 형성해 에이징케어의 기본을 튼튼히 잡아주는 에멀젼", "중성" , "로션" );

cosAdd[1][21] =new Cosmetic("순수 마일드 크림" , 17500 , "한율" , "쉽게 민감해지는 피부도 순하고 촉촉하게 케어해 주는 저자극 보습 크림" , "중성" , "로션" );

cosAdd[1][22] =new Cosmetic( "에이지 컨트롤 스킨 소프너" , 15400 , "마몽드" , "피부 결을 매끄럽게 정돈하여 효능 흡수의 바탕을 다지는 풍성한 보습감의 안티에이징 스킨" , "중성" , "스킨");

cosAdd[1][23] =new Cosmetic("히아루로닉 에멀젼" , 22400 , "아이오페" , "히아루론산이 함유되어 촉촉하고 매끈한 피부로 가꾸어 주는 보습 로션" , "중성" , "로션");

cosAdd[1][24] =new Cosmetic("극진 스킨" , 42000 , "한율" , "피부톤과 결을 맑고 균일하게 정돈해주는 고농축 스킨" , "중성" , "스킨");
cosAdd[1][25] =new Cosmetic("퓨어화이트 울트라액티브 에멀젼" , 16800 , "마몽드" , "피부 칙칙함은 지워주고 탱탱함은 채워주는 백목련 탄력미백 로션" , "중성" , "로션" );

cosAdd[1][26] =new Cosmetic("퍼펙트 리뉴 스킨 리파이너" , 26600 , "라네즈" , "끈적임없이 스며들어 수분을 가득 채우는 촉촉한 스킨" , "중성" , "스킨" );
//
cosAdd[1][27] =new Cosmetic("극진 에멀젼" , 49000 , "한율" , "피부 본연의 턴오버를 원활하게 회복시켜주는 프리미엄 한방 로션" , "중성" , "로션" );

cosAdd[1][28] =new Cosmetic("라이브 리프트 크림" , 38500 , "아이오페" , "쫀쫀하게 밀착되어 촉촉하고 탄력 넘치는 피부로 가꿔주는 안 티에이징 탄력 크림" , "중성" , "로션" );

cosAdd[1][29] =new Cosmetic("동안 앰플 멀티 뷰티크림" , 11200 , "아리따움" , "한번에 에센스와 크림, 수딩마스크의 3in1 역할의 올인원 멀 티 크림" , "중성" , "로션" );


//<지성용 화장품 리스트 >

cosAdd[2][0] =new Cosmetic( "어린쑥 수분진정 토너" , 15400 , "한율" , "피부 진정효과가 있는 어린쑥이 피부를 편안하게 감싸주고 피부결을 부드럽게 정돈하는 마일드한 어린쑥 토너" , "지성" , "스킨");

cosAdd[2][1] =new Cosmetic( "청순 올인원 크림" , 32000 , "가온도담" , "수분부족형 지성피부에 딱맞는 최강보습 올인원크림" , "지성" , "로션" );

cosAdd[2][2] =new Cosmetic( "모이스처 세라마이드 크림" , 20300 , "마몽드" , "빈틈 없는 밀착 보습을 통해 튼튼한 피부 장벽을 만들어 주는 무궁화 보습 장벽 크림" , "지성" , "로션");

cosAdd[2][3] =new Cosmetic( "워터뱅크 젤 크림 " , 25900 , "라네즈" , "하루종일 촉촉하게 수분이 차오르는 산뜻한 젤 타입 수분크림" , "지성" , "로션");

cosAdd[2][4] =new Cosmetic( "어성초 포어 클린 토너" , 12600 , "마몽드" , "블랙헤드 및 묵은 각질을 정리해주고 모공 수렴 효과가 뛰어난 어성초 모공 클리닝 토너 (천연유래성분 99.3% 함유)" , "지성" , "스킨");

cosAdd[2][5] =new Cosmetic( "모이스처 세라마이드 라이트 크림" , 20300, "마몽드", "빈틈 없는 밀착 보습을 통해 튼튼한 피부 장벽을 만들어 주는 산뜻한 타입의 무궁화 보습 장벽 크림" , "지성" , "로션");

cosAdd[2][6] =new Cosmetic( "플로랄 하이드로 에멀젼" , 12600 , "마몽드" ,"수분감 넘치는 발림성과 밀착 흡수력으로 건조한 피부에 즉각적으로 촉촉함을 더하는 수분 밸런싱 에멀젼" , "지성" , "로션");

cosAdd[2][7] =new Cosmetic( "플로랄 하이드로 크림" , 15400 , "마몽드" , "산뜻한 수분 텍스처로 끈적임 없이 촉촉함을 오래 지속시켜주는 수분 저장 크림" , "지성" , "로션" );

cosAdd[2][8] =new Cosmetic( "프레시 카밍 토너" , 18200 , "라네즈" , "피부 유수분 밸런스를 맞춰주고, 산뜻하고 개운한 피부로 만들어주는 수분 진정 토너" , "지성" , "스킨");

cosAdd[2][9] =new Cosmetic( "포어 리셋 매티파잉 토너" , 17500 , "아이오페" , "녹차 추출물이 모공을 청결하게 케어하고, 파우더가 모공 속과 겉의 과다 피지를 흡착하여 하루종일  보송한 피부로 유지시켜주는 토너" , "지성" , "스킨" );

cosAdd[2][10] =new Cosmetic( "AC 밸런스 토너" , 9100, "마몽드" , "묵은 각질과 노폐물을 부드럽게 닦아 내고 과다하게 분비된 피지를 케어해 주어 피부를 청량하게 수렴해주는 바하 솔루션 토너" , "지성" , "스킨");

cosAdd[2][11] =new Cosmetic( "AC 밸런스 에멀젼" ,10500 , "마몽드" , "피부 유ㆍ수분 밸런스를 조절해주며 얇은 수분 막을 형성하여 속 당김 없이 산뜻하게 촉촉함을 부여하는 바하 솔루션 에멀젼" ,"지성" , "로션" );

cosAdd[2][12] =new Cosmetic("슈퍼바이탈 크림 바이오 엑설런트" , 70000 , "아이오페", "바이오 셀레티노이드™가 동시다발적으로  일어나는 피부노화현상을 빈틈없이 케어하는 토탈  안티에이징 크림" , "지성" , "로션");

cosAdd[2][13] =new Cosmetic("더마트러블 토너" ,21000, "아이오페", "지친 피부를 진정시키고 피부 정화효과를 부여하는 트러블 피부용 토너" , "지성" , "스킨" );

cosAdd[2][14] =new Cosmetic( "더마트러블 에멀젼", 22400 , "마몽드" , "피부의 스트레스를 완화하고 피부장벽을 강화하여 건강한 피부로 가꾸어주는 트러블 피부용 에멀젼" ,"지성" , "로션");

cosAdd[2][15] =new Cosmetic( "아쿠아 필 토너" , 10500 , "마몽드" , "피부 표면의 불필요한 각질을 시원하게 닦아내어 매끄럽고 촉촉한 피부로 가꾸어주는 개운한 각질 보습 토너" , "지성" , "스킨");
//
cosAdd[2][16] =new Cosmetic("더마 리페어 스킨 워터" , 19600 , "아이오페" , "피부에 존재하는 칼슘 이온 성분 함유, 피부를 촉촉하게 적셔 주는 스피드 진정 수렴 토너" , "지성" , "스킨");

cosAdd[2][17] =new Cosmetic("아토 인텐시브 모이스처 크림" , 26600 , "아이오페" , "피부 건조로 인한 가려움을 완화하여 건강한 피부로 가꾸어 주는 보습 장벽 케어 크림", "지성" , "로션" );

cosAdd[2][18] =new Cosmetic("화이트듀 스킨 리파이너" , 21000 , "라네즈" , "가볍고 산뜻하게 피부에 흡수되어 고른 피부톤으로 개선시켜 주는 수분 화이트닝 스킨" , "지성" , "스킨" );

cosAdd[2][19] =new Cosmetic("화이트듀 에멀젼" , 23100 , "라네즈" , "물방울 터지듯 흡수되어 피부를 환하고 촉촉하게 가꿔주는 수 분 화이트닝 에멀젼" , "지성" , "로션" );

cosAdd[2][20] =new Cosmetic("화이트 플러스 리뉴 오리지널 크림" , 35000 , "라네즈" , "피부에 수분광채코팅한듯 수분은 잡고 피부를 보호하는 래디 언스 화이트닝 크림" , "지성" , "로션" );

cosAdd[2][21] =new Cosmetic("화이트듀 톤업크림" , 26600 , "라네즈" , "바르는 즉시 노랗고 칙칙한 피부톤을 환하게 연출시켜 주는 촉촉한 제형의 수분 화이트닝 톤업 크림" , "지성" , "로션" );

cosAdd[2][22] =new Cosmetic("화이트젠 크림" , 42000 , "아이오페" , "칙칙한 피부톤과 잡티를 케어하고 매끄럽고 윤기있는 피부를 가꾸어주는 화이트닝 크림" , "지성" , "로션" );

cosAdd[2][23] =new Cosmetic("더마트러블 크림" , 24500 , "아이오페" , "불균형한 피부 유.수분 밸런스를 맞추어주고 약한 피부를 보 호하는 트러블 피부용 크림" , "지성" , "로션" );

cosAdd[2][24] =new Cosmetic("라이브 리프트 에멀젼" , 25900 , "아이오페" , "유수분 밸런스를 맞춰주며 촘촘하고 매끄러운 피부로 가꿔 주 는 안티에이징 탄력 에멀젼" , "지성" , "로션" );
cosAdd[2][25] =new Cosmetic("랑콤 토닉 두쎄르" , 55000 , "랑콤" , "로즈 워터(장미수)를 함유하여 피부를 부드럽고 촉촉하게 가꾸어주는 모든 피부용 토너" , "지성" , "스킨" );

cosAdd[2][26] =new Cosmetic("블랑 엑스퍼트 에센스 인 로션" , 65000 , "랑콤" , "액틸 C 화이트닝 성분이 촉촉하고 환한 수분광 피부를 완성" , "지성" , "로션" );

cosAdd[2][27] =new Cosmetic("토닉 꽁포르 토너" , 53000 , "랑콤" , "유연하고 풍부한 젤에 가까운 텍스쳐가 피부를 매끄럽고 촉촉하게 해준다. 아몬드, 곡물추출물, 효모 추출물, 꿀 성분이 피부에 영양 및 부드러움을 선사합니다." , "지성" , "스킨");

cosAdd[2][28] =new Cosmetic("리-뉴트리브 크림" , 120000 , "에스티로더" , "피부를 풍부한 영양을 공급해주는 에스티로더의 베스트셀러 영양크림" , "지성" , "로션" );

cosAdd[2][29] =new Cosmetic("캡춰 토탈 드림 스킨" , 115000 , "디올" , "특별한 기술, 디올이 선보이는 신개념 토탈 뷰티케어로 놀라운 속도로 피부 보연의 아름다움을 되찾아주어 화장기 없는 자연스러운 얼굴을 경험할 수 있습니다. 더불어 점차적으로 세월의 흔적을 없애 균일한 피부관리에 도움을 줍니다." , "지성" , "스킨" );
		
 
		 //리스트 출력
		 int i,j;
			for (i = 0;i<cosAdd.length ;i++ )	
			{
				for (j = 0;j<cosAdd[i].length ;j++ )
				{
					dao.insertCosmetic((cosAdd[i][j]));
				}
			 System.out.println();
			}
			System.out.println();
			
}	


		
		
	}
}

