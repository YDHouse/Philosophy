package com.philosophy.yd.yourphilosophy;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


class D00_DBManager extends SQLiteOpenHelper {

    //다른 클래스에서 현 클래스를 호출할 수 있게 스태틱으로 선언
    static D00_DBManager dbManager;

    D00_DBManager(Context context) {
        super(context, "YourPhilosophy.db", null, 1);

        //onCreate() 메소드가 실행되면서 (혹은 생성자로 클래스를 호출할 때)
        //현 클래스가 스태틱으로 메모리에 등록된다.
        //이 구문이 빠지면 스태틱 선언을 해도 this 로 지정된 곳이 없기 때문에
        //nullPointerException 이 발생하므로 반드시 지정해 주어야 한다.
        dbManager = this;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE `PHILOSOPHY` ( `ID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `SECTION` INTEGER NOT NULL, `CONTENT` TEXT NOT NULL, 'AUTHOR' TEXT NOT NULL, 'ANNOTATION' TEXT NOT NULL, 'FAVORITE' INTEGER NOT NULL )");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 1,'언젠가 내 스승께선 말씀하셨다. 자신이 얼마나 변했는지 알고 싶다면 아직 변하지 않는 곳으로 가보라 하셨다.','마의 1편 손창민의 대사',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 1,'인간은 자유를 원할 때에만 자유로워진다. 다른 사람은 우리가 자신을 해치고 상처낼 때에만 우리에게 상처 입힐 수 있다. 불행이라는 것은 우리에게 일어난 일 때문이 아니라 그 일에 대해서 우리가 가지고 있는 생각, 믿음, 선입견......, 즉 표상이다.','에픽테토스<space>공지영 - 네가 어떤 삶을 살던 나는 너를 응원 할 것이다. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 1,'넌 네가 있을 곳을 찾고 있다고 말했어.','영화 냉정과 열정사이 대사',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 1,'비록 몸은 세속의 열 평 방 속에 갇혀 있으되 마음은 우주 삼라만상을 두루 넘나들 수 있으니 어찌 스스로 봉황이 되어 무한창공을 자유롭게 날지 못하고 한 마리 굴뚝새가 되어 구차하게 돌 틈에 몸을 숨기랴.','이외수 - 날다 타조: 자신을 무가치하다고 생각하는 그대에게',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 1,'철학을 추구하는 자는 마음이 자유로워야 한다.','포톨레마이오스',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 2,'도 안에서 걸림 없이 행동하는 사람은 그 자신의 이해에 얽매이지 않으며, 또 그런 개인적인 이해에 얽매여 있는 사람을 경멸하지도 않는다. 그는 재물을 모으고자 애쓰지 않으며 그렇다고 청빈의 덕을 내세우지도 않는다. 그는 남에게 의존함 없이 자신의 길을 걸어가며, 또한 홀로 걸어감을 자랑하지도 않는다. 대중을 따르지 않으면서도 대중을 따르는 자를 비난하지 않는다. 어떤 지위와 보상도 그의 마음을 끌지 못하며 불명예와 부끄러움도 그의 길을 가로막지 못한다. 그는 매사에 옳고 그름을 판단하지 않으며 긍정과 부정에 좌우되지도 않는다. 그런 사람을 도의 사람이라 부른다.','장자 - 도의 사람<space>류시화 - 사랑하라 한 번도 상처받지 않은 것처럼. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 2,'어느 날 페르시아의 왕이 신하들에게 마음이 슬플 때는 기쁘게<space>기쁠 때는 슬프게 만드는 물건을 가져올 것을 명령했다.<space><space>신하들은 밤새 모여 앉아 토론한 끝에 마침내 반지 하나를 왕에게 바쳤다.<space>왕은 반지에 적힌 글귀를 읽고는 크게 웃음을 터뜨리며 만족해했다.<space>반지에는 이런 글귀가 새겨져 있었다.<space>이것 또한 지나가리라.<space><space>슬픔이 그대의 삶으로 밀려와 마음을 흔들고 소중한 것들을 쓸어가 버릴 때면<space>그대 가슴에 대고 다만 말하라.<space>이것 또한 지나가리라.<space><space>행운이 그대에게 미소 짓고 기쁨과 환희로 가득할 때 근심 없는 날들이 스쳐갈 때면<space>세속적인 것들에만 의존하지 않도록 이 진실을 조용히 가슴에 새기라.<space>이것 또한 지나가리라.<space>','랜터 윌슨 스미스 - 이것 또한 지나가리라<space>류시화 - 사랑하라 한 번도 상처받지 않은 것처럼. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 2,'세상에는 변치 않는 마음과 굴하지 않는 정신이 있다. 순수하고 진실한 영혼들도 있다.<space>그러므로 자신이 가진 최상의 것을 세상에 주라. 최상의 것이 너에게 돌아오리라.<space>사랑을 주면 너의 삶으로 사랑이 모이고 가장 어려울 때 힘이 될 것이다.<space>삶을 신뢰하라. 그러면 많은 이들이 너의 말과 행동을 신뢰할 것이다.<space>마음의 씨앗들을 세상에 뿌리는 일이 지금은 헛되이 보일지라도<space>언젠가는 열매를 거두게 되리라.<space>왕이든 걸인이든 삶은 다만 하나의 거울, 우리의 존재와 행동을 비춰 줄 뿐.<space>자신이 가진 최상의 것을 세상에 주라. 최상의 것이 너에게 돌아오리라.<space>','메들린 브리지스 - 인생 거울<space>류시화 - 사랑하라 한 번도 상처받지 않은 것처럼. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 2,'산이 날 에워싸고<space>씨나 뿌리며 살아라 한다.<space>밭이나 갈며 살아라 한다.<space><space>어느 산자락에 집을 모아<space>아들 낳고 딸을 낳고<space>흙담 안팎에 호박 심고<space>들찔레처럼 살아라 한다.<space>쑥대밭처럼 살아라 한다.<space><space>산이 날 에워싸고<space>그믐달처럼 사위어지는 목숨<space>구름처럼 살아라 한다.<space>바람처럼 살아라 한다.','박목월 - 산이 날 에워싸고',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 2,'온순하고, 선량하고, 공손하고, 검소하고, 겸양하다.','공자<space>정후수 - 주희가 집주한 논어',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 2,'어떤 사람이 공자에게 묻길,<space>공자께서는 어찌 정치를 안 하십니까?<space><space>공자 답하길,<space>서경에 효를 말하였다. 오직 효도하며, 형제에게 우애가 도탑게 하여 그것으로 정치에 베푼다 하였으니, 이 또한 정치를 하는 것이니 어찌 꼭 정치에 참여하는 것만을 정치라 하겠는가?','공자<space>정후수 - 주희가 집주한 논어',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 2,'인을 갖춘 마을에 사는 것은 아름다운 일이다. 그러므로 인한 마을을 골라서 살지 않으면 어찌 지혜롭다 하겠는가.','공자<space>정후수 - 주희가 집주한 논어','주석1.<space>사람들이 어질고, 또 두터운 덕이 있는 마을이 좋은 곳이다. 이런 좋은 마을을 골라서 살지 않으면 그것은 옳고 그름을 판단하는 본심을 잃은 것이다. 따라서 그런 사람은 지혜롭다고 할 수 없다.<space><주희 : 정후수 주희가 집주한 논어>',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 2,'직위가 없을까 걱정하지 말고 직위에 걸맞은 능력이 부족할까를 걱정하라.<space>나를 알아주는 사람이 없다고 걱정하지 말고 남이 알아줄 만한 재능을 얻기 위해 노력하라.','공자<space>푸지에 - 명쾌한 논어 21세기에 답하다.','주석1.<space>덕이 있는 군자에게는 할 수 있는 일과 할 수 없는 일이 있다.<space>군자는 품격이 고상하여 타인에게 존경을 받을 수 있지만,<space>타인이 반드시 자신을 존중하도록 할 수는 없다.<space>충성스럽고 성실하여 사람들에게 신뢰를 받을 수는 있지만,<space>타인이 반드시 자신을 신뢰하도록 할 수는 없다.<space>다재다능하여 타인에게 쓰임을 받을 수는 있지만,<space>타인이 반드시 자신을 쓰도록 할 수는 없다.<space>그러므로 군자는<space>자신의 품격이 높지 않음을 수치스럽게 여기지,<space>자신이 멸시 받음은 부끄럽게 여기지 않는다.<space>자신이 성실하지 않음을 부끄럽게 여기지,<space>신뢰받지 못함을 부끄럽게 여기지는 않는다.<space>자신의 무능을 부끄럽게 여기지,<space>자신이 쓰임을 받지 못함을 부끄럽게 여기지는 않는다.<space>그러므로 군자는<space>명예와 영광에 유혹을 받지 않으며 비난과 훼방에도 뒤로 물러서지 않는다.<space>일을 할 때 도의를 지키며, 자신을 엄격하고 단정하게 관리하고, 외부의 사물에 정신을 빼앗기지 않는다.<space>이것이 바로 진정한 군자이다.<space><순자 : 푸지에 - 명쾌한 논어 21세기에 답하다. 에서 발췌>',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 2,'다른 집 자식들은 봄꽃이겠지. 넌 바람, 비 지난 뒤에 피어나는 가을꽃이고. . . 아직은 너의 계절이 아닌데 마음만 급했구나. 살아 있으니까 흔들리는 거야. 살아 있는 나무라 부러지지 않으려고 흔들리는 게야. 그래야 비바람 잦아들면 꽃이 피잖어. 서두르지 말고 각자의 계절을 기더려야겠지. 이 세상에 꽃이 피지 않는 나무가 어디 있을까?','김동화 - 빨간 자전거 2권: 아버지와 아들 편',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 2,'자주 그리고 많이 웃는 것, 현명한 이에게 존경을 받고 아이들에게서 사랑을 받는 것, 정직한 비평가의 찬사를 듣고 친구의 배반을 참아내는 것, 아름다움을 식별할 줄 알며 다른 사람에게서 최선의 것을 발견하는 것, 건강한 아이를 낳든 한 뙈기의 정원을 가꾸든 사회 환경을 개선하든 자기가 태어나기 전보다 세상을 조금이라도 살기 좋은 곳으로 만들어 놓고 떠나는 것, 자신이 한때 이곳에 살았음으로 해서 단 한 사람의 인생이라도 행복해지는 것, 이것이 진정한 성공이다.','랄프 왈도 에머슨 - 무엇이 성공인가<space>류시화 - 지금 알고 있는 걸 그때도 알았더라면. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 2,'사회는 구성원 개개인의 인간성에 반하는 음모의 굴레이다. 사회는 일종의 주식회사와 같다. 그 안에서 구성원들은 각자의 몫을 안전하게 지키기 위해 자유와 문화를 포기하는데 동의한다. 여기에서 가장 요구되는 덕목은 순응이며, 자립은 반목일 뿐이다. 사회는 현실과 창조자들을 좋아하지 않으며, 이름과 관습을 사랑한다. 그러나 인간이고자 한다면 순응하지 않는 자가 되어야 한다. 불멸의 야자열매(승리)를 얻고자 하는 사람은 선의 이름 앞에 흔들려서는 안 되며, 우선 그것이 진정한 선인지 따져보아야 한다. 우리의 정직한 마음만큼 신성한 것은 없다. 따라서 스스로 자신을 용서할 수 있다면 세계의 동의를 얻게 될 것이다.','랄프 왈도 에머슨 - 세상의 중심에 너 홀로 서라.','주석1.<space>순응에 대하여 장자는 도의 사람에서 대중을 따르지 않으면서도 대중을 따르는 자들을 비난하지 않는다. 고 하였다. 이는 사회에 속해 있는(혹은 반드시 속해야만 하는) 일반인들이 대중을 벗어나 자신만의 삶(도의 삶을 추구하는 것)을 사는 것이 얼마나 힘든 일인가를 알게 해주는 대목이다.',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 2,'나는 내가 반드시 해야 하는 일들만 생각할 뿐, 남들이 어떻게 생각하는지는 신경 쓰지 않는다. 이러한 규칙은 실생활과 지적인 삶에서 똑같이 어려운 일이지만, 위대함과 평범함을 나누는 기준이 되기도 한다. 이러한 분별은 당신의 의무가 무엇인지 당신보다 더 잘 안다고 생각하는 사람들이 꼭 있기 때문에 더욱 어렵다. 세상 속에서 세상의 견해에 순응하며 살아가는 것은 쉬운 일이다. 또한 홀로 존재한다면 자신의 견해를 따라 사는 것도 쉬운 일이 될 것이다. 그러나 위대한 사람은 군중 속에서도 완벽한 온화함을 유지하며 고독하게 홀로 서는 사람이 아니겠는가!','랄프 왈도 에머슨 - 세상의 중심에 너 홀로 서라.',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 2,'목자 : 내 식사는 준비되었고 암양의 젖도 짜 두었습니다. 내 집 대문은 잠기어 있고 불은 타고 있습니다. 그러니 하늘이여, 마음대로 비를 내려도 좋습니다.<space><space>붓다 : 내게는 더 이상 음식이나 젖이 필요하지 않습니다. 바람이 내 처소이며 불 또한 꺼졌습니다. 그러니 하늘이여, 마음대로 비를 내려도 좋습니다.<space><space>목자 : 내게는 황소가 있습니다. 내게 암소가 있습니다. 내 아버지에게서 물려받은 목초지도 있고 내 암소를 모두 거느릴 씨받이 소도 있습니다. 그러니 하늘이여, 마음대로 비를 내려도 좋습니다.<space><space>붓다 : 내게는 황소도 암소도, 목초지도 없습니다. 내겐 아무것도 없습니다. 나는 아무것도 두렵지 않습니다. 그러니 하늘이여, 마음대로 비를 내려도 좋습니다.<space><space>목자 : 내게는 말 잘 듣고 부지런한 양치기 여자가 있습니다. 오래전부터 이 여자는 내 아내였습니다. 밤에 아내를 희롱하는 나는 행복합니다. 그러니 하늘이여, 마음대로 비를 내려도 좋습니다.<space><space>붓다 : 내게는 자유롭고 착한 영혼이 있습니다. 나는 오래전부터 내 영혼을 길들여 왔고, 나와 희롱하는 것도 가르쳐 놓았습니다. 그러니 하늘이여, 마음대로 비를 내려도 좋습니다.','니코스 카잔차키스 - 그리스인 조르바: 붓다와 목자의 대화',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 2,'오늘은 내 남은 인생의 첫 날이다.','센트럴파크의 어느 벤치에 누군가가 새겨놓은 낙서',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 2,'그대가 진실로 행복한 인생을 살고 싶거나 아름다운 인생을 살고 싶다면 현재 자신이 알고 있는 자신을 철저하게 거부하라. 그것들은 모조리 허상이다. 과감하게 허상을 목졸라 버리고 그대의 진체가 무엇인지를 탐구하라. 모든 사람이 군자로 태어났으되 스스로 군자가 되기를 거부하며 살고 있으니, 어찌 세상과 인생이 아름답고 행복하기를 바라겠는가.','이외수 - 날다 타조: 자신을 무가치하다고 생각하는 그대에게',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 2,'혼자 가만히 있다가<space>갑자기 허무 해지고<space>아무 말도 할 수 없고<space><space>가슴이 터질 것만 같고<space>눈물이 쏟아질 것만 같아<space>누군가를 만나고 싶은데<space>만날 사람이 없다<space>주위에는 항상 친구들이 있다고 생각했는데<space>이런 날 이런 마음을<space>들어 줄 사람을 생각하니<space><space>수첩에 적힌 이름과 전화번호를<space>읽어 내려가 보아도 모두가 아니었다.<space><space>혼자 바람 맞고 사는 세상<space>거리를 걷다 가슴을 삭이고<space>마시는 뜨거운 잔의 커피<space>아 삶이란 때론 이렇게 외롭구나.','이해인 - 어느 날의 커피',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 2,'다른 사람들이 기대하는 것보다 더 많이, 그리고 진심으로 기뻐하며 주라.<space>자신이 가장 좋아하는 시를 외우라.<space>들리는 모든 것을 믿지는 말라.<space>때로 자신이 갖고 있는 모든 것을 써버려라, 아니면 실컷 잠을 자라.<space><space>첫눈에 반하는 사랑을 믿으라.<space>다른 사람의 꿈을 절대로 비웃지 말라. 꿈이 없는 사람은 가난한 사람이니깐.<space>사랑은 깊고 열정적으로 하라. 상처 받을 수도 있지만<space>그것만이 완전한 삶을 사는 유일한 길이다.<space><space>위대한 사랑과 위대한 성취는 엄청난 위험을 동반한다는 사실을 기억하라.<space>실패하더라도, 그것을 통해 배움을 얻는 일에까지 실패하지는 말라.<space><space>때로는 침묵이 가장 좋은 해답이 될 수 있음을 기억하라.<space>변화하는데 인색하지 말라. 그러나 자신의 가치관을 지켜라.<space>무엇보다 바람직하고 존경할 만한 삶을 살라.<space>늙어서 자신의 생을 돌아볼 때 또다시 그것을 살게 될 테니까.<space><space>신을 믿으라, 하지만 차는 잠그고 다니라, 숨은 뜻을 알아차리라.<space>당신의 지식을 남과 나누라. 그것이 영원한 삶을 얻는 길이므로.<space>기도하라, 헤아릴 수 없이 많은 힘이 거기에 있다.<space><space>자신이 실수한 것을 깨닫는 순간, 즉시 바로잡으라.<space>즐겁게 대화를 나눌 수 있는 사람과 결혼하라. 늙으면 그것이 아주 중요해질 테니까.<space>하지만 가끔 혼자 있는 시간을 가지라.<space><space>일 년에 한 번은, 전에 전혀 가보지 않았던 곳을 찾아가라.<space>돈을 많이 벌었다면 살아 있을 때 다른 사람을 돕는데 쓰라.<space>그것이 부가 가져다주는 가장 큰 만족이다.<space>자신이 원하는 걸 얻지 못하는 것이 때로는 큰 행운일 수 있다는 점을 기억하라.<space><space>규칙을 배우고 나서, 그중 몇 가지를 위반하라.<space>무엇을 얻기 위해 무엇을 포기했는가를 자신의 성공을 평가하는 기준으로 삼으라.<space>자신의 성격이 곧 자신의 운명임을 기억하라.','작자 미상 - 삶을 위한 지침: 처음에는 행운을 가져다주는 네팔 탄트라토템 또는 딜라이 라마의 만트라 라는 제목으로 알려진 시<space>류시화 - 사랑하라 한 번도 상처받지 않은 것처럼. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 2,'나 하늘로 돌아가리라.<space>새벽빛 와 닿으면 스러지는<space>이슬 더불어 손에 손을 잡고,<space><space>나 하늘로 돌아가리라.<space>노을빛 함께 단둘이서<space>기슭에서 놀다가 구름 손짓하면은,<space><space>나 하늘로 돌아가리라.<space>아름다운 이 세상 소풍 끝내는 날,<space>가서, 아름다웠더라고 말하리라……','천상병 - 귀천',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 2,'삶이 하나의 놀이라면 이것이 그 놀이의 규칙이다.<space>당신에게는 육체가 주어질 것이다.<space>좋든 싫든 당신은 그 육체를 이번 생 동안 갖고 다닐 것이다.<space><space>당신은 삶이라는 학교에 등록할 것이다. 수업시간이 하루 스물네 시간인 학교에.<space>당신은 그 수업을 좋아할 수도 있고, 쓸모없거나 어리석은 것이라 여길 수도 있다.<space>하지만 충분히 배우지 못하면 같은 수업이 반복될 것이다.<space>그런 후에 다음 과정으로 나아갈 것이다. 당신이 살아 있는 한 수업은 계속되리라.<space><space>당신은 경험을 통해 배우리라.<space>실패는 없다. 오직 배움만이 있을 뿐.<space>실패한 경험은 성공한 경험만큼 똑같이 중요한 과정이므로.<space><space>‘이곳’ 보다 더 나은 ‘그곳’은 없다.<space>다른 사람들은 모두 당신을 비추는 거울이다.<space>어떤 삶을 만들어 나갈 것인가는 전적으로 자신에게 달려 있다.<space>필요한 해답은 모두 자신 안에 있다.<space><space>그리고 태어나는 순간 당신은 이 모든 규칙을 잊을 것이다.','체리 카터 스코트 - 삶이 하나의 놀이라면<space>류시화 - 사랑하라 한 번도 상처받지 않은 것처럼. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 2,'내가 태어났을 때, 나는 울었고, 내 주변의 모든 사람은 웃고 즐거워하였다.<space>내가 내 몸을 떠날 때, 나는 웃었고, 내 주변의 모든 사람은 울며 괴로워하였다.<space><space>덧없는 삶에의 유혹으로부터 벗어나라.<space>자만심으로부터, 무지로부터, 어리석음의 광기로부터, 속박을 끊으라.<space>그때 비로소 그대는 모든 괴로움으로부터 완전히 자유로우리라.<space><space>생과 사의 사슬을 끊으라.<space>어리석은 삶으로 빠져드는 이치를 알고 그것을 끊어 버리라.<space>그때 비로소 그대는 이 지상의 삶에 대한 욕망으로부터 자유롭게 되어<space>고요하고 평온하게 그대의 길을 걸어가리라.','티베트 사자의 서 - 내가 태어났을 때<space>류시화 - 사랑하라 한 번도 상처받지 않은 것처럼. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 2,'과거의 교훈이나 미래의 꿈을 살아내는 것처럼 지금 이 순간, 최선을 다해 살고 싶었다.','파울로 코엘료 - 연금술사',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 2,'한낱 양치기에게도 삶에 대한 질문이 그토록 중요할 수 있다는 걸 예전에는 결코 상상도 하지 못했었다.','파울로 코엘료 - 연금술사',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 3,'고독이란 누군가 곁에 있다고 하더라도 결코 사라지지 않는 것. 고독이란 군중 속에 있을 때 더더욱 사무치는 것. 고독에서 벗어날 수 있는 유일한 방법은 스스로 더욱 큰 고독 속으로 뛰어드는 것 밖에 없다.','이외수 - 이외수가 전해주는 마음의 열쇠, 뼈',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 3,'이것은 내가 읽을 수 있는 유일한 시, 나는 그 시를 쓸 수 있는 유일한 시인. 모든 게 엉망이었을 때도 나는 자살하지 않았다. 약물에 의존하려고도 가르침을 얻으려고도 하지 않았다. 대신 나는 잠을 자려고 애썼다. 하지만 아무리 애써도 잠이 오지 않을 때는 시 쓰는 법을 배웠다. 바로 오늘 같은 밤, 바로 나 같은 누군가가 읽을지도 모를 이런 시를 위해.','레너드 코헨 - 나의 시<space>류시화 - 사랑하라 한 번도 상처받지 않은 것처럼. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 3,'아무리 어둔 길이라도<space>나 이전에<space>누군가는 이 길을 지나갔을 것이고,<space>아무리 가파른 길이라도<space>나 이전에<space>누군가는 이 길을 통과했을 것이다.<space>아무도 걸어가 본 적이 없는<space>그런 길은 없다.<space>나의 어두운 시기가<space>비슷한 여행을 하는<space>모든 사랑하는 사람들에게<space>도움을 줄 수 있기를.<space>','베드로시안 - 그런 길은 없다<space>류시화 - 지금 알고 있는 걸 그때도 알았더라면. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 3,'당신이 생존을 위해 무엇을 하는가는 내게 중요하지 않다.<space>당신이 무엇 때문에 고민하고 있고, 자신의 가슴이 원하는 것을 이루기 위해<space>어떤 꿈을 간직하고 있는가 나는 알고 싶다.<space><space>당신이 몇 살인가는 내게 중요하지 않다.<space>나는 다만 당신이 사랑을 위해 주위로부터 비난받는 것을<space>두려워하지 않을 자신이 있는가 알고 싶다.<space><space>어떤 행성 주위를 당신이 돌고 있는가는 중요하지 않다.<space>당신이 슬픔의 중심에 가닿은 적이 있는가.<space>삶으로부터 배반당한 경험이 있는가.<space>그래서 잔뜩 움츠러든 적이 있는가.<space>또한 앞으로 받을 더 많은 상처 때문에 마음을 닫은 적이 있는가 알고 싶다.<space><space>나의 것이든 당신 자신의 것이든 당신이 기쁨과 함께할 수 있는가 나는 알고 싶다.<space>미친 듯이 춤출 수 있고, 그 환희로 손가락 끝과 발가락 끝까지 채울 수 있는가.<space>당신 자신이나 나에게 조심하라고, 현실적이 되라고, 인간의 품위를 잃지 말라고<space>주의를 주지 않고 서 그렇게 할 수 있는가.<space><space>당신의 이야기가 진실인가 아닌가는 중요하지 않다.<space>당신이 다른 사람들을 실망시키는 한이 있더라도 자기 자신에게는 진실할 수 있는가.<space>배신했다는 주위의 비난을 견디더라도 자신의 영혼을 배신하지 않을 수 있는가 알고 싶다.<space><space>어떤 것이 예쁘지 않더라도 당신이 그것의 아름다움을 볼 수 있는가<space>그것이 거기에 존재한다는 사실에서 더 큰 의미를 발견할 수 있는가 나는 알고 싶다.<space><space>당신이 누구를 알고 있고 어떻게 이곳까지 왔는가는 내게 중요하지 않다.<space>다만 당신이 슬픔과 절망의 밤을 지새운 뒤 지치고 뼛속까지 멍든 밤이 지난 뒤<space>자리를 떨치고 일어날 수 있는가 알고 싶다.<space><space>나와 함께 불길의 한가운데 서 있어도 위축되지 않을 수 있는가.<space>모든 것이 떨어져 나가더라도 내면으로부터 무엇이 당신의 삶을 지탱하고 있는가.<space><space>그리고 당신이 자기 자신과 홀로 있을 수 있는가.<space>고독한 순간이 자신과 함께 있는 것을 진정으로 좋아할 수 있는가 알고 싶다.','오리아 마운틴 드리머 - 초대<space>류시화 - 사랑하라 한 번도 상처받지 않은 것처럼. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 3,'인간이라는 존재는 여인숙과 같다.<space>매일 아침 새로운 손님이 도착한다.<space><space>기쁨, 절망, 슬픔<space>그리고 약간의 순간적인 깨달음 등이<space>예기치 않은 방문객처럼 찾아온다.<space><space>그 모두를 환영하고 맞아들이라.<space>설령 그들이 슬픔의 군중이어서<space>그대의 집을 난폭하게 쓸어가 버리고<space>가구들을 몽땅 내가더라도.<space><space>그렇다 해도 각각의 손님을 존중하라.<space>그들은 어떤 새로운 기쁨을 주기 위해<space>그대를 청소하는 것인지도 모르니까.<space><space>어두운 생각, 부끄러움, 후회<space>그들을 문에서 웃으며 맞으라.<space>그리고 그들을 집 안으로 초대하라.<space>누가 들어오든 감사하게 여기라.<space><space>모든 손님은 저 멀리에서 보낸<space>안내자들이니까.<space>','잘랄루딘 루미 - 여인숙<space>류시화 - 사랑하라 한 번도 상처받지 않은 것처럼. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 3,'마음 안에서 일어나는 일들을 어찌 육안으로만 판단하랴. 눈에 보이는 건 오히려 믿을 수 없는 것이다. 눈에 보이는 것 치고 인간의 마음을 속이지 않는 것이 별로 없다. 자연의 마음을 알지 못하면 인간의 마음을 알 수가 없고, 인간의 마음을 알지 못하면 하늘의 마음을 알 수가 없다.','이외수 - 이외수가 전해주는 마음의 열쇠, 뼈',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 3,'“저기가 오아시스요.”<space><space>“그런데 어째서 우리는 지금 당장 저곳으로 가지 않는 거죠?”<space><space>“지금은 잘 시간이니까.”','파울로 코엘료 - 연금술사',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 3,'초조해하지 말자. 먹을 때는 먹기만, 길을 떠나야 할 때는 떠날 뿐.','파울로 코엘료 - 연금술사',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 3,'그대의 보물이 있는 곳에 그대의 마음 또한 있을 것이네.','파울로 코엘료 - 연금술사',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 3,'초심자의 행운이라고 불렀던 것도 더 이상 힘을 발휘하지 못했다. 그는 알고 있었다. 이제 그를 기다리는 것은, 자아의 신화를 추구하는 사람의 끈기와 용기를 시험하는 시련뿐이라는 것을. 그 때문에 그는 서두를 수도, 초조해할 수도 없었다. 만일 그렇게 된다면 신이 그의 앞길에 준비해놓은 표지들을 못 보고 지나칠 수도 있었다.','파울로 코엘료 - 연금술사',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 3,'우리가 지금의 우리보다 더 나아지기를 갈구할 때, 우리를 둘러싼 모든 것들도 함께 나아진다는 걸 그들은 우리에게 보여주는 거지.','파울로 코엘료 - 연금술사',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 3,'“난 아직 살아 있어.”<space><space>“난 음식을 먹는 동안엔 먹는 일 말고는 아무것도 하지 않소. 걸어야 할 땐 걷는 것, 그게 다지. 만일 내가 싸워야 하는 날이 온다면, 그게 언제가 됐든 남들처럼 싸우다 미련 없이 죽을 거요. 난 지금 과거를 사는 것도 미래를 사는 것도 아니니까. 내겐 오직 현재만이 있고, 현재만이 내 유일한 관심거리요. 만약 당신이 영원히 현재에 머무를 수만 있다면 당신은 진정 행복한 사람일 게요. 그럼 당신은 사막에도 생명이 존재하며 하늘에는 무수한 별들이 있다는 사실을, 전사들이 전투를 벌이는 것은 그 전투 속에 바로 인간의 생명과 연관된 그 무엇이 있기 때문이라는 사실을 깨닫게 될 거요. 생명은 성대한 잔치며 크나큰 축제요, 생명은 우리가 살고 있는 오직 이 순간에만 영원하기 때문이오.”','파울로 코엘료 - 연금술사: 사막의 낙타 몰이꾼과의 대화 중에서',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 4,'강변에서<space>내가 사는 작은 오막살이집까지<space>이르는 숲길 사이에<space>어느 하루<space>마음먹고 나무계단 하나<space>만들었습니다<space><space>밟으면 삐걱이는<space>나무 울음소리가 산 뻐꾸기 울음<space><space>소리보다 듣기 좋았습니다<space>언젠가는 당신이<space>이 계단을 밟고<space>내 오막살이집을 찾을 때<space>있겠지요<space><space>설령 그때 내게<space>나를 열렬히 사랑했던<space>신이 찾아와<space>자, 이게 네가 그 동안 목마르게 찾았던 그 물건이야<space>하며 막 봇짐을 푸는 순간이라 해도<space>난 당신이 내 나무계단을 밟는 소리<space>놓치지 않고 들을 수 있습니다<space>그리고는 신과는 상관없이<space>강변 숲길을 따라 달려가기 시작할 것입니다','곽재구 - 계단',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 4,'어느 이름 모를 거리에서<space>예고 없이 그대와 마주치고 싶다<space>그대가 처음<space>내 안에 들어왔을 때의<space>그 예고 없음처럼','구영주 - 헛된 바람',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 4,'자세히 보아야<space>예쁘다<space><space>오래 보아야<space>사랑스럽다<space><space>너도 그렇다','나태주 - 풀꽃',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 4,'너에게로 가지 않으려고 미친 듯 걸었던<space>그 무사한 길도<space>실은 네게로 향한 것이었다.','나희덕 - 푸른 밤 중에서 일부 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 4,'천사람 중의 한 사람은 형제보다 더 가까이 네 곁에 머물 것이다.<space>생의 절반을 바쳐서라도 그런 사람을 찾을 필요가 있다.<space>그 사람이 너를 발견하기를 기다리지 말고.<space>구백아흔아홉 사람은 세상 사람들이 바라보는 대로 너를 바라볼 것이다.<space>하지만 그 천 번째 사람은 언제까지나 너의 친구로 남으리라.<space>세상 모두가 너에게 등을 돌릴지라도.<space><space>그 만남은 목적이나 겉으로 내보이기 위한 것이 아닌 너를 위한 진정한 만남이 되리라.<space>천 사람 중의 구백아흔아홉 사람은 떠나갈 것이다.<space>너의 표정과 행동에 따라, 또는 네가 무엇을 이루는가에 따라.<space>그러나 네가 그 사람을 발견하고 그가 너를 발견한다면 나머지 사람들은 문제가 아니니라.<space>그 천 번째 사람이 언제나 너와 함께 물 위를 헤엄치고,<space>물속으로도 기꺼이 가라앉을 것이기에.<space><space>때로 그가 너의 지갑을 사용할 수도 있지만, 넌 더 많이 그의 지갑을 사용할 수 있으리라.<space>많은 이유를 대지 않고서도.<space>그리고 날마다 산책길에서 웃으며 만나리라. 마치 서로 빌려 준 돈 따위는 없다는 듯이.<space>구백아흔아홉 사람은 거래할 때마다 담보를 요구하리라.<space>하지만 천 번째 사람은 그들 모두를 합친 것보다 더 가치가 있다.<space>너의 진실한 감정을 그대에게 보여 줄 수 있으므로.<space><space>그의 잘못이 너의 잘못이고, 그의 올바름이 곧 너의 올바름이 되리라.<space>태양이 비칠 때나 누비가 내릴 때나.<space>구백아흔아홉 사람은 모욕과 비웃음을 견디지 못할 것이다.<space>하지만 그 천 번째 사람은 언제나 네 곁에 있으리라.<space>함께 죽음을 맞이하는 한이 있더라도. 그리고 그 이후에도.','루디야드 키플링 - 천 사람 중의 한 사람<space>류시화 - 사랑하라 한 번도 상처받지 않은 것처럼. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 4,'너 처음 만났을 때<space>사랑한다 이 말은 너무 작았다<space>같이 살자 이 말은 너무 흔했다<space>그래서 너를 두곤 목숨을 내걸었다<space>목숨의 처음과 끝 천국에서 지옥까지 가고 싶었다.<space>맨발로 너와 함께 타오르고 싶었다.<space>죽고 싶었다.','문정희 - 사랑의 노래',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 4,'인생에 있어 아름다운 젊은 시절엔 서로 헤어진다 해도 곧 다시 만날 거라 여기기 마련. 그러나 언젠가 그대와 나 늙어 시들어지면, 그 옛날의 안녕이란 말 그리 쉽게 할 수가 없네.','샨 사 - 천안문의 여자',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 4,'비뚤어진 미소 일랑 집어 치워.<space>나는 지금 다른 여자를<space>사랑하고 있어.<space>너는 아니다.<space>너는 너 자신이 알고 있을 거야.<space>잘 알고 있고말고.<space>내가 쳐다보는 것은 네가 아니다.<space>너에게 온 것도 아니다.<space>네 옆을 그냥 지나쳐도<space>내 마음은 아무렇지도 않아.<space>다만<space>창문을 들여다보고 싶었을 뿐이야.','세르게이 에세닌 - 손을 부비며<space>공지영 - 네가 어떤 삶을 살던 나는 너를 응원 할 것이다. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 4,'동령부인(同齡夫人),<space>사돈집 팔순잔치라도 가는 길일까<space>앞자린엔 할매와 할배,<space>옆자리엔<space>왠지 낯설지 않은<space>중년 여인.<space>(숙영이라 부르자!)<space><space>차창밖엔 눈이 내리는데<space>나의 설경엔<space>숙영의 얼굴이, 자꾸<space>걸린다.<space><space>지금 어딘 가엔,<space>저 얼굴 그리는 사람 필경 있겠다.<space>‘꿈에라도 한번 봤으면<space>잠깐이라도 보았으면…….‘<space>그 사람한테 미안하다,<space>그 얼굴을 내 혼자 보고 있다<space>서울서 목포까지.<space><space>말하자면 숙영과 나는 지금, 기차를 타고<space>나란히 앉아서<space>눈 내리는 들판을 지나고 있다.','윤제림 - 숙영과 나는 지금',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 4,'문든 아름다운 것과 마주쳤을 때<space>지금 곁에 있으면 얼마나 좋을까 하고<space>떠오르는 얼굴이 있다면 그대는<space>사랑하고 있는 것이다.<space><space>그윽한 풍경이나<space>제대로 맛을 낸 음식 앞에서<space>아무도 생각나지 않는 사람<space>그 사람은 정말 강하거나<space>아니면 진짜 외로운 사람이다.<space><space>종소리를 더 멀리 보내기 위하여<space>종은 더 아파야 한다.','이문재 - 농담<space>류시화 - 사랑하라 한 번도 상처받지 않은 것처럼. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 4,'내가 그다지 사랑하던 그대여<space>내 한평생 차마 그대를 잊을 수 없소이다<space>내 차례에 못 올 사랑인줄은 알면서도<space>나 혼자는 꾸준히 생각하리라<space>자 그러면 내내 어여쁘소서','이상 - 이런 시',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 4,'낮은 곳에 있고 싶었다.<space>낮은 곳이라면 지상의 그 어디라도 좋다.<space>찰랑찰랑 물처럼 고여들 네 사랑을 온몸으로 받아들일 수만 있다면<space>한 방울도 헛되이 새어 나가지 않게 할 수만 있다면<space><space>그래, 내가 낮은 곳에 있겠다는 건<space>너를 위해 나를 온전히 비우겠다는 뜻이다.<space>나의 존재마저 너에게 흠뻑 주고 싶다는 뜻이다.<space><space>잠겨 죽어도 좋으니 너는<space>물처럼 내게 밀려오라.','이정하 - 낮은 곳으로',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 4,'사랑하는 사람이기보다는<space>진정한 친구이고 싶다<space>다정한 친구이기보다는<space>진실이고 싶다<space><space>내가 너에게 아무런 의미를 줄 수 없다 하더라도<space>너는 나에게 만남의 의미를 전해 주었다<space><space>순간의 지나가는 우연이기 보다는<space>영원한 친구로 남고 싶었다.<space>언젠가는 헤어져야 할 너와 나이지만<space>아름다운 추억으로 남을 수 있는<space>친구이고 싶다<space><space>모든 만남이 그러하듯<space>너와 나의 만남을 영원히 간직하기 위해<space>진실로 너를 만나고 싶다<space>그래, 이제 더 나이기 보다는<space>우리이고 싶었다.<space>우리는 아름다운 현실을 언제까지 변치 않는<space>마음으로 접어두자<space><space>비는 싫지만 소나기는 좋고<space>인간은 싫지만 너만은 좋다<space><space>내가 새라면 너에게 하늘을 주고<space>내가 꽃이라면 너에게 향기를 주겠지만<space>나는 인간이기에 너에게 사랑을 준다.','이해인 - 너에게 띄우는 글',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 4,'만일 내가 무엇인가로 돌아온다면<space>눈물로 돌아오리라.<space>너의 가슴에서 잉태되고<space>너의 눈에서 태어나<space>너의 뺨에서 살고<space>너의 입술에서 죽고 싶다.<space>눈물처럼.','작자 미상 - 눈물<space>류시화 - 사랑하라 한 번도 상처받지 않은 것처럼. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 4,'봄의 정원으로 오라.<space>이곳에 꽃과 술과 촛불이 있으니<space>만일 당신이 오지 않는다면<space>이것들이 무슨 의미가 있는가.<space><space>그리고 만일 당신이 온다면<space>이것들이 또한 무슨 의미가 있는가.','잘랄루딘 루미 - 봄의 정원으로 오라<space>류시화 - 사랑하라 한 번도 상처받지 않은 것처럼. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 4,'내 그대를 사랑함에 있어서 한 점 부끄럼 없다.<space>단지 후회를 하나 하자면<space>그 날,<space>그대를 내 손에서 놓아버린 것 뿐<space>어느새 화창하던 그 날이 지나고<space>하늘에선 차디찬 눈이 내려오더라도<space>그 눈마저 소복소복 따뜻해 보이는 것은<space>그대를 향한 내 사랑일까<space><space>꽃이 진다고 그대를 잊은 적 없다.','정호승 - 꽃이 진다고 그대를 잊은 적 없다',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 4,'해가 말했다.<space><space>“내가 있는 이 자리는 세상에서는 아주 먼 곳이지만, 나는 여기서 사랑하는 법을 배웠어. 내가 지구에 조금만 더 가까이 가면, 지구에 있는 모든 것들은 죽어버리고, 만물의 정기도 사라져버릴 거라는 걸 난 잘 알아. 그래서 우리는 떨어져 서로를 바라보며 사랑을 해.”','파울로 코엘료 - 연금술사',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 4,'사랑을 하게 되면 항상 지금의 자신보다 더 나아지고 싶어 하니까.','파울로 코엘료 - 연금술사',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 4,'슬프다<space>내가 사랑했던 자리마다<space>모두 폐허다','황지우 - 뼈아픈 후회 중에서 일부 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 5,'나는 지식보다 상상력이 더 중요함을 믿는다. 신화가 역사보다 더 많은 의미를 담고 있음을 나는 믿는다. 꿈이 현실보다 더 강력하며 희망이 항상 어려움을 극복해 준다고 믿는다. 그리고 슬픔의 유일한 치료제는 웃음이며 사랑이 죽음보다 더 강하다는 걸 나는 믿는다. 이것이 내 인생의 여섯 가지 신조이다.','로버트 풀검 - 내 인생의 신조<space>류시화 - 지금 알고 있는 걸 그때도 알았더라면. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 5,'생각을 의식적이고, 체계적이고, 건설적으로 지휘해야지만 원하는 것을 얻을 수 있다.','찰스 해낼 - 성공의 문을 여는 마스터키',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 5,'우선 자신에게 힘이 있음을 알아야 하고, 둘째로는 부딪치려는 용기가 있어야 하며, 셋째로는 실제로 행할 정도의 믿음이 있어야 한다.','찰스 해낼 - 성공의 문을 여는 마스터키',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 5,'우주의 마음에 있는 무한한 힘과 무한한 지혜를 인정함으로써 최대한의 혜택을 얻을 수 있고, 이렇게 해서 우리는 무한한 존재가 우리 소망을 실현하기 위해 사용하는 통로가 될 수 있다. 이 말은 인정하면 실현된다는 뜻이다. 아름다움, 웅대함, 초월적인 기회들을 당신의 뜻대로 사용할 수 있음을 이해하게 될 것이다.','찰스 해낼 - 성공의 문을 여는 마스터키',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 5,'참된 집중의 방법은 무엇인가? 생각하는 대상과 하나가 되어서 다른 것은 의식하지 못하는 것. 이러한 집중 방법의 결과는 무엇인가? 생각과 일치하는 조건을 틀림없이 가져다줄, 보이지 않는 힘을 움직인다.','찰스 해낼 - 성공의 문을 여는 마스터키',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 5,'자아의 신화를 이루어내는 것이야말로 이 세상 모든 사람들에게 부과된 유일한 의무지. 자네가 무언가를 간절히 원할 때 온 우주는 자네의 소망이 실현되도록 도와준다네.','파울로 코엘료 - 연금술사',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 6,'어떤 일에건 사심 없이 십년만 투자하라. 언제나 그대를 낮추고 한없이 겸손한 마음으로 만물을 대하면 누구든 십년 이내에 성인의 반열에 오르게 되리라.','이외수',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 6,'그대에게도 하늘은 열려 있다.','이외수 - 날다 타조',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 6,'절대 고독, 번데기는 캄캄한 고치 속에서 도대체 무엇을 꿈꾸고 있는 것일까.. . .  그대여. 번데기가 캄캄한 고치 속에서 절대 고독을 견디고 밖으로 나오면 날개를 가진 나방이 된다는 사실에 유념하라. 비로소 하늘을 날아다닐 수 있음에 유념하라. . . 그러나 그대여. 그대가 만약 날개를 가지고 싶다면 누에의 한 살이 중에서 특히 고치의 부분을 소중히 생각하라. 비록 그대에게 절대 고독이 찾아온다고 하더라도 결코 도망치거나 주저앉지 말아야 한다.','이외수 - 날다 타조: 희망이 없다고 생각하는 그대에게',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 6,'결정이란 단지 시작일 뿐이다. 어떤 사람이 한 가지 결정을 내리면 그는 세찬 물줄기 속으로 잠겨 들어서, 결심한 순간에는 꿈도 꿔보지 못한 곳으로 가게 된다.','파울로 코엘료 - 연금술사',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 6,'자신의 꿈에 가까이 다가갈수록, 어려움은 점점 더 커지고 있었다.','파울로 코엘료 - 연금술사',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 6,'자신 있게 꿈을 향해 나아가고 상상해 온 삶을 살려고 노력하는 일이라면, 일상 속에서 예기치 못한 성공을 만날 것이다.','헨리 데이비드 소로우<space>공지영 - 네가 어떤 삶을 살던 나는 너를 응원 할 것이다. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 7,'세 사람이 있는데 가장 힘센 자가 가장 힘없는 자를 착취하려 할 때 나머지 한 사람이 네가 나를 죽이지 않고서는 이 힘없는 자를 아프게 하지 못 할 것이다.라고 말할 때 하늘나라는 이미 이곳에 있다.','???<space>공지영 - 네가 어떤 삶을 살던 나는 너를 응원 할 것이다. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 7,'예수께서 이르시되, 신을 믿으라. 내가 진실로 너희에게 이르노니 누구든지 이 산더러 바다에 던져지라 하면, 그 말하는 것이 이루어질 줄 믿고 마음에 의심하지 아니하면 그대로 되리라. 그러므로 내가 너희에게 말하노니 무엇이든지 기도하고 구하는 것은 받은 줄로 믿으라. 그리하면 너희에게 그대로 되리라. 서서 기도할 때에 아무에게나 혐의가 있거든 용서하라. 그리하여야 하늘에 계신 너희 아버지께서도 너희 허물을 사하여 주시리라 하시니라.','마가복음 11장 24절',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 7,'내가 진실로 너희에게 이르노니 너희가 여기 내 형제 중에 지극히 작은 자 한 사람에게 한 것이 곧 내게 한 것이니라.','마태복음 25장 40절<space>혜민 - 멈추면 비로소 보이는 것들. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 7,'주여, 주여 하는 자마다 다 천국에 들어갈 것이 아니요, 다만 하늘에 계신 내 아버지의 뜻대로 행하는 자라야 들어가리라.','마태복음 7장 21절<space>혜민 - 멈추면 비로소 보이는 것들. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 7,'고뇌하는 너의 가슴속에만 진리가 있다고 생각하지 말라. 모든 마당과 모든 숲, 모든 집 속에서 그리고 모든 사람들 속에서 진리를 볼 수 있어야 한다. 목적지에서, 모든 여행길에서, 모든 순례 길에서, 진리를 볼 수 있어야 한다. 모든 길에서, 모든 철학에서, 모든 단체에서, 진리를 볼 수 있어야 한다. 모든 행동에서, 모든 동기에서, 모든 생각과 감정에서 그리고 모든 말들 속에서 진리를 볼 수 있어야 한다. 마음속의 광명뿐 아니라 세상의 빛줄기 속에서도 진리를 발견할 수 있어야 한다. 온갖 색깔과 어둠조차 궁극적으로 아무런 차이가 없다. 진정으로 진리를 본다면 진정으로 사랑하기 원한다면 그리고 행복하기를 원한다면 광활한 우주의 어느 구석에서도 진리를 만날 수 있어야 한다.','스와미 묵타난다 젊은 수도자에게<space>류시화 - 지금 알고 있는 걸 그때도 알았더라면. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 7,'나는 나 자신의 힘으로 어떻게 해서든지 이루어 보려고 노력해 보지 않는 것에 대해서는 절대로 하느님에게 기도해서 이루어 달라고 부탁드리지 않는다. 만약 어떻게 해서든지 이루어 보려고 노력해 본 다음에 도저히 가망이 없어서 기도를 드릴 경우에 하느님은 길게 사설을 늘어놓지 않아도 대번에 아실 것이다. 중요한 것은 진실 그 자체이니까. . . 하지만 진실 된 마음을 가지고 간절히 기도해도 이루어지지 않는 것은 하느님의 생각으로 나의 바람이 이루어지더라도 나에게 이익 됨이 없다고 판단하셨기 때문이다.','이외수 - 이외수가 전해주는 마음의 열쇠, 뼈',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 8,'원칙 없는 정치 (철학없는 정치)<space><space>노동 없는 부 (노동 없는 부)<space><space>양심 없는 쾌락 (윤리 없는 쾌락)<space><space>인격 없는 지식 (인격 없는 교육)<space><space>도덕성 없는 상업 (도덕 없는 경제)<space><space>인간성 없는 과학 (인간성 없는 과학)<space><space>희생 없는 신앙 (헌신 없는 종교)<space><space>이 후에 아룬 간디가 ㅡ 책임 없는 권리를 추가','간디 7가지 사회악',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 8,'배우고 때로 익히면 또한 즐겁지 아니한가.','공자<space>정후수 - 주희가 집주한 논어','주석1.<space>상등의 지식인은 도를 들으면 부지런히 실행한다. 중등의 지식인은 도를 들으면 반신반의한다. 하등의 지식인은 도를 들으면 큰소리로 깔깔대며 비웃는다. 조소를 받지 않는 도는 도라고 할 수 없다.<space><노자 : 푸지에 - 명쾌한 논어 21세기에 답하다. 에서 발췌><space><space>주석2.<space>지혜로운 사람은 도를 들으면 적극적으로 실행한다. 평범한 사람은 도를 들으면 어리둥절해하며 핵심을 깨닫지 못한다. 어리석은 사람은 도를 들으면 비현실적인 이야기로 치부하며 조롱과 멸시를 일삼는다. 그러나 만일 어리석은 사람들의 조소를 받지 못한다면 그 도는 진정한 도라 할 수 없다. 노자의 관점을 증명하는데 논어를 이용하는 것은 아주 적절한 방법이며, 금상첨화라 할 수 있다.<space><푸지에 - 명쾌한 논어 21세기에 답하다.>',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 8,'배우기만 하고 생각하지 않으면 얻는 것이 없고, 생각만 하고 배우지 않으면 위태롭다.','공자<space>정후수 - 주희가 집주한 논어','주석1.<space>정자 말하길, 널리 배우고, 자세히 묻고, 차분히 생각하고, 분명히 분별하고, 독실하게 행동하는 다섯 가지 중에 그 하나라도 없앤다면, 이것은 학문을 하는 것이 아니다.<space><주희 : 정후수 - 주희가 집주한 논어>',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 8,'공부하되 사색하지 않으면 어리석어지고, 사색하되 공부하지 않으면 의혹에 빠진다.','공자<space>푸지에 - 명쾌한 논어 21세기에 답하다.',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 8,'내 굼뜬 발걸음과 떨리는 손을 이해하는 자에게 복이 있나니,<space>그가 하는 말을 알아듣기 위해 오늘 내 귀가 얼마나 긴장해야 하는가를<space>이해하는 자에게 복이 있나니,<space><space>내 눈이 흐릿하고 무엇을 물어도 대답이 느리다는 걸 이해하는 자에게 복이 있나니,<space>오늘 내가 물 컵을 엎질렀을 때 그것을 별 일 아닌 걸로 여겨 준 자에게 복이 있나니,<space><space>기분 좋은 얼굴로 찾아와 잠시나마 잡담을 나눠 준 자에게 복이 있나니,<space>나더러 그 얘긴 오늘만도 두 번이나 하는 것이라고 핀잔주지 않는 자에게 복이 있나니,<space><space>내가 사랑받고 혼자가 아니라는 걸 알게 해주는 자에게 복이 있나니,<space>내가 찾아갈 기력이 없을 때 내 집을 방문해 준 의사에게 복이 있나니,<space><space>사랑으로 내 황혼녘의 인생을 채워 주는 모든 이에게 복이 있나니,<space>내가 아직 살아 있을 수 있도록 나를 보살펴 주는 내 가족들 모두에게 복이 있나니,<space>하늘나라가 그들의 것이라.','그랙 맥도널드 - 75세 노인이 쓴 산상수훈<space>류시화 - 지금 알고 있는 걸 그때도 알았더라면. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 8,'1) 나 스스로 명확하게 참이라고 인정한 것 외에는 어떤 것도 참이라고 받아들이지 마라. - 계속 의문을 가져라.<space><space>2) 모든 문제를 큰 덩어리로만 바라보지 말고 가능한 한 작게 세분하라. - 건너뛰지 말고 완전히 이해하라.<space><space>3) 가장 단순하고 이해하기 쉬운 대상에서 점차 단계를 밟아 복잡하고 난해한 문제에 접근하라. - 토대가 중요하다.<space><space>4) 어떤 항목도 빠지지 않았다는 확신이 들 때까지 모든 항목을 열거하고, 그것에 대해 광범위하게 재검토하라. - 완전할 때까지 복습하라.','데카르트 학문에 대한 네가지 규칙<space>박경철 자기혁명. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 8,'1) 자신의 사회에서 가장 보편적인 가치에 복종하고 온건하며 신앙을 굳건히 하고, 극단적인 의견의 편에 서지 마라.<space><space>2) 행동을 취하는 순간에는 의연하고 명확한 태도를 취하라. 아무리 의심스러운 결정이었다 하더라도 일단 결정을 내린 다음이라면 완전한 확신을 갖고 그것에 따르라.<space><space>3) 주어진 운명을 따르기보다 자신의 한계를 극복하기 위해 노력하며, 세상을 바꾸려는 노력 이전에 자신의 그릇된 욕망을 다스리는 데 주력하라.<space><space>4) 위 세 가지를실펀하는 바탕 위에서 일할 수 있는 직업을 선택하라.','데카르트 학문에 대한 네가지 규칙<space>박경철 자기혁명. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 8,'당신 자신의 생각을 믿는 것, 당신 자신의 마음속에서 진실이라고 믿는 것은 곧 다른 모든 사람에게도 진실이다. 이것이 재능이다.','랄프 왈도 에머슨 - 세상의 중심에 너 홀로 서라.',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 8,'주여 내가 할 수 있는 일은 최선을 다해 하게 해 주시고, 내가 할 수 없는 일은 체념할 줄 아는 용기를 주시며 이 둘을 구분할 수 있는 지혜를 주소서','성 프란치스코의 기도문<space>공지영 - 네가 어떤 삶을 살던 나는 너를 응원 할 것이다. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 8,'곧은 나무 쉬 꺾인다.','속담',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 8,'세상의 미친 자들에게 붙여지는 이름이 있다.<space>현실 부적응자, 반항아, 문제아, 부적합 판정을 받은 자.<space>사물을 다른 각도에서 바라보는 자들, 이들은 규칙을 좋아하지 않는다.<space>그리고 현상 유지를 별로 존중하지 않는다.<space><space>당신은 그들의 말을 인용할 수 있고, 그들에게 동의하지 않을 수도 있고,<space>그들을 칭찬하거나 비난할 수도 있다.<space>하지만 그들에 대해 당신이 할 수 없는 단 한 가지는 그들을 무시하는 일.<space>왜냐하면 그들은 사물을 바꿔 놓기 때문이다.<space><space>그들은 발명하고, 상상하고, 치료한다. 탐험하고, 창조하고, 영감을 불어넣는다.<space>그들은 인류를 앞으로 나아가게 만든다. 어쩌면 그들은 미쳐야만 하는지도 모른다.<space>그렇지 않고 어떻게 텅 빈 화폭에서 그림을 볼 수 있겠는가.<space>어떻게 침묵 속에 앉아 결코 써진 적이 없는 노래를 들을 수 있겠는가.<space>또는 붉은 행성들을 응시하면서 우주 정거장을 떠올릴 수 있겠는가.<space><space>어떤 사람들은 그들을 미치광이라 부르지만, 우리는 그들을 천재라 부른다.<space>세상을 바꿀 수 있다고 생각할 만큼 미친 사람들만이 결국 세상을 바꿀 수 있기 때문이다.','어느 고등학교 교사가 썼다고 전해지는 이 시는 애플 컴퓨터 사의 텔레비전 광고에 사용되었다.<space>류시화 - 사랑하라 한 번도 상처받지 않은 것처럼. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 8,'지금 증명된 것은 예전에 누군가 상상만 했던 것이다.','윌리엄 브레이크',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 8,'동일한 지식은 동일한 방식으로 대중들에게 주입되어서는 안 된다.','융',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 8,'언어는 마음의 거울이다. 마음이 각박하면 자연히 되고 거센 발음을 자주 내뱉게 되는 것이다.','이외수 - 이외수가 전해주는 마음의 열쇠, 뼈',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 8,'인문학을 배운 다는 것은 그 책을 쓴 천재와 대화할 수 있는 기회이다.','이지성 - 리딩으로 리드하라',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 8,'고요히 앉아 본 뒤에야 평상시의 마음이 경박했음을 알았네.<space>침묵을 지킨 뒤에야 지난날의 언어가 소란스러웠음을 알았네.<space>일을 돌아본 뒤에야 시간을 무의미하게 보냈음을 알았네.<space>문을 닫아건 뒤에야 앞서의 사귐이 지나쳤음을 알았네.<space>욕심을 줄인 뒤에야 이전의 잘못이 많았음을 알았네.<space>마음을 쏟은 뒤에야 평소에 마음 씀이 각박했음을 알았네.','진계유 - 뒤에야<space>류시화 - 사랑하라 한 번도 상처받지 않은 것처럼. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 8,'두려움을 없애고 싶다면, 용기에 집중하라. 부족함을 없애고 싶다면, 풍요에 집중하라. 질병을 없애고 싶다면, 건강에 집중하라.','찰스 해낼 - 성공의 문을 여는 마스터키',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 9,'우리는 불행의 그물이 있다는 사실을 잘 알고 있으면서도 관능적인 향락의 성에서 한 치도 떠나지 못한다. ','이외수 - 이외수가 전해주는 마음의 열쇠, 뼈',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 9,'먼저 집착을 버려라. 집착은 욕망을 낳는다.','이외수 - 이외수가 전해주는 마음의 열쇠, 뼈',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 9,'고통 당하는 사람은 자신의 고통을 자신과 동일시하기 때문에 고통과 작별하는 것을 두려워한다. 왜냐하면 고통은 그가 알고 있는 것이지만, 그 고통을 놓아 버린 후에 그를 기다리고 있는 것은 그가 모르는 것이기 때문이다. 우리 모두는 늘 우리를 비난하는 사람들을 배심원석에 앉혀 놓고, 피고석에 앉아 우리의 행위를 변명하고자 하는 강박에 사로잡혀 있다. 네 자신을 아프게 할 수 있는 사람은 오직 네 자신뿐이다.','안셀름 그륀 신부 - 너 자신을 아프게 하지 마라<space>공지영 - 네가 어떤 삶을 살던 나는 너를 응원 할 것이다. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 9,'우리는 자신이 다른 사람에 관하여 만들어 낸 생각에 일치하게끔 그 사람을 체험한다. 어느 한 사람을 열광적으로 찬탄한다면, 우리는 그가 저지른 가장 정신 나간 일도 황홀하게 바라보고, 유일하며 비범한 것으로 해석한다. 화난 안경이나 실만한 안경으로 바라보면, 우리는 그를 마음에 안 들고 불쾌하고 해악하며 아주 간사하고 부정직한 등등의 사람으로 체험하게 된다. 그렇기 때문에 이 세상에서 올바로 살기 위해서는 우리의 표상과 표상을 투사하는 배후를 묻고, 사물과 사람들을 하느님의 빛 안에서 상상하는 것이 중요하다. 그래야만 우리는 참으로 자유롭게 사물과 사람들을 대할 수 있다. 그러면 사물들이 더 이상 우리에게 상처를 입히지 않는다.','에픽테토스 & 요한 크리소스토모 & 안셀름 그륀 신부<space>공지영 - 네가 어떤 삶을 살던 나는 너를 응원 할 것이다. 에서 발췌','주석1.<space>위녕, 무엇인가에 표상을 투사하는 너의 배후는 무엇이니? 네 속에 없는 것을 네가 남에게 줄 수는 없다. 네 속에 미움이 있다면 너는 남에게 미움을 줄 것이고, 네 속에 사랑이 있다면 너는 남에게 사랑을 줄 것이다. 네 속에 상처가 있다면 너는 남에게 상처를 줄 것이고, 네 속에 비꼬임이 있다면 너는 남에게 비꼬임을 줄 것이다. 네가 사랑하는 사람이 있다면 그는 어떤 의미든 너와 닮은 사람일 것이다. 자기 속에 있는 것을 알아보고 사랑하게 된 것일 테니까. 만일 네가 미워하거나 싫어하는 사람이 있다면 그는 너와 어떤 의미이든 닮은 사람이 것이다. 네 속에 없는 것을 그에게서 알아볼 수는 없을 테니까 말이야. 하지만 네가 남에게 사랑을 주든, 미움을 주든, 어떤 마음을 주든 사실, 그 결과는 고스란히 네 것이 된다. 이 사실을 깨닫게 되면 말 한마디 시선 하나가 두려워진다. 정말 두려워져. 위녕, 우리는 가끔 어처구니없는 가시덤불에 걸리기도 하고, 모욕의 골짜기에 떨어지기도 하지, 너의 선의와는 아무 상관없이 너는 매를 맞을 수도 있고, 창피를 당할 수도 있어, 그러나 명심해야 할 것은 우리가 설사 그 일을 막을 수는 없지만 그 일을 마음속으로 자리매김할 수는 있다는 거야. 그건 우리에게 달린 일이거든, 그리고 우리에게 달릴 수밖에 없는 일이기도 해. 오늘 아침에 우연히 마주치게 된 모욕에 오늘 하루를 내줄 것인가, 생명이 약동하는 이 오월의 아름다움에 네 마음을 내줄 것인가를 결정하는 것은 너 자신이지, 그것은 나쁘고 좋고의 문제가 아니라 그저 너의 선택이라는 거야. 이 시간의 주인이 되어라. 네가 자신에게 선의와 긍지를 가지고 있다면 궁극적으로 너를 아프게 할 사람은 아무도 없다. 네 성적이 어떻든, 네 성격이 어떻든, 네 체중이 어떻든 너는 이 시간의 주인이고 우주에서 가장 귀한 사람이라는 생명이다. 위녕, 힘들다고 했지? 그래 힘들지. 누구나 그 시절을 다 힘들게 보냈어. 그런데 너의 힘듦은 진정 어디서 오니? 그래 이왕 힘든 거, 힘든 시간을 나를 분발시키고 나를 향상시키는 기회로 삼아 보면 어떨까? 미안하다, 그것이 더 힘든 걸 알면서도 이렇게 또 지당한 소리를 늘어놓게 되었구나. 그러나 위녕. 사실을 말하면 엄마는 네가 이 시기를 좀 잘못 넘어도 괜찮다고 생각하고 있어. 그래도 돼. 너는 아직 젊고 또 많은 기회가 있을 거야. 이 한 해로 너의 모든 것을 판단하고 싶지 않아. 그래서도 안 되고……. 사랑한다. 사랑한다는 것은 그 사람을 있는 그대로 받아들인다는 것을 이제야 알게 된 엄마의 미안한 사랑을 보낸다.<space><공지영 - 네가 어떤 삶을 살던 나는 너를 응원 할 것이다.>',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 9,'슬픔이 너를 지배하도록 내버려두지 말라. 쓸데없는 근심이 너의 날들을 뒤흔들게 내버려두지 말라. 책과 사랑하는 이의 입술을 풀밭의 향기를 저버리지 말라. 대지가 너를 그의 품에 안기 전에 어리석은 슬픔으로 너 자신을 너무 낭비하지 말라. 그 대신 축제를 열라. 불공정한 길 안에 정의의 예를 제공하라. 왜냐하면 이 세계의 끝은 무이니까. 네가 존재하지 않다고 가정하라. 그리고 자유롭다고.','오마르 카이얌 - 중세기 회교도의 충고<space>류시화 - 사랑하라 한 번도 상처받지 않은 것처럼. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 9,'슬픔은 주머니 속 깊이 넣어 둔 뾰족한 돌멩이와 같다.<space>날카로운 모서리 때문에 당신은 이따금 그것을 꺼내 보게 될 것이다.<space>비록 자식이 원치 않을 때라도.<space><space>때로 그것이 너무 무거워 주머니에 넣고 다니기 힘들 때는<space>가까운 친구에게 잠시 맡기기도 할 것이다.<space>시간이 지날수록 주머니에서 그 돌멩이를 꺼내는 것이 더 쉬워지리라.<space>전처럼 무겁지도 않으리라.<space><space>이제 당신은 그것을 다른 사람들에게, 때로는 낯선 사람에게까지 보여 줄 수 있을 것이다.<space>그리고 어느 날 당신은 돌멩이를 꺼내 보고 놀라게 되리라.<space>그것이 더 이상 상처를 주지 않는다는 걸 알고.<space>왜냐하면 시간이 지나면서 당신의 손길과 눈물로 그 모서리가 둥글어졌을 테니까.','작자 미상 - 슬픔의 돌<space>류시화 - 사랑하라 한 번도 상처받지 않은 것처럼. 에서 발췌',' ',0);");
        db.execSQL("INSERT INTO PHILOSOPHY VALUES (null, 9,'사람은 누구나 화를 낼 수 있다. 그것은 쉬운 것이다. 그러나 올바른 사람에게 화를 내는 것, 알맞게 화를 내는 것, 적재적소에서 화를 내는 것, 올바른 화를 내는 것, 그리고 올바른 방법으로 화를 내는 것, 그것은 누구나 할 수 있는 것이 아니다. 그것은 절대로 쉬운 것이 아니다.','아리스토텔레스',' ',0);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DELETE FROM PHILOSOPHY");
    }

    //카테고리 별 쿼리 실행
    ArrayList<C20_ItemsAll> querySelect(int queryNumber) {
        //쿼리 실행 후 쿼리 값을 각 각의 컬럼 별로 나누기 위해 변수 선언
        String mContentId = "";     //ID
        String mContent = "";       //글의 내용
        String mAuthor = "";        //출처
        String mAnnotation = "";    //주석
        String mFavorite = "";      //즐겨찾기

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor;

        //DB 값들이 최종적으로 저장될 리스트
        ArrayList<C20_ItemsAll> resultDB = new ArrayList<>();

        if (queryNumber == 0 ) {
            //쿼리넘버가 0이면 내가 좋아하는 글 쿼리를 실행하고
            cursor = db.rawQuery("select * from PHILOSOPHY where favorite = 1", null);
        } else {
            //쿼리넘버가 0이 아니면 섹션 별 쿼리를 실행한다.
            cursor = db.rawQuery("select * from PHILOSOPHY where SECTION = " + queryNumber + "", null);
        }

        //섹션 별 쿼리에서는 null 값이 나올 경우가 없지만
        //즐겨찾기 쿼리에서는 null 값이 나올 수 있기 때문에 cursor 값을 확인한다.
        if (cursor != null && cursor.getCount() != 0) {
            while (cursor.moveToNext()) {
                //나중에 데이터를 나누기 위해 기호(/)를 추가해서 각 변수에 담는다.
                //참고로 1번은 section
                mContentId += cursor.getString(0) + "/";    //0번은 ID
                mContent += cursor.getString(2) + "/";      //2번은 글의 내용
                mAuthor += cursor.getString(3) + "/";       //3번은 출처
                mAnnotation += cursor.getString(4) + "/";   //4번은 주석
                mFavorite += cursor.getString(5) + "/";     //5번은 즐겨찾기
            }

            //하나의 변수에 DB의 값이 전부 들어가 있기 때문에 기호 '/' 를 기준으로 나누어 준다.
            String[] contentIdSplit = mContentId.split("/");
            String[] contentSplit = mContent.split("/");
            String[] authorSplit = mAuthor.split("/");
            String[] annotationSplit = mAnnotation.split("/");
            String[] favoriteSplit = mFavorite.split("/");

            //배열의 크기만큼 반복을 돌리기 위해 글의 내용을 나눈 contentSplit 길이의 값을 변수 k에 저장
            int k = contentSplit.length;

            int number = 1;
            for (int i=0; i<k; i++){
                //content, author, favorite 컬럼 값을 C20_ItemsAll 에 저장한다.
                //content, author, annotation 값을 저장할 때는 글 띄움 효과를 준다.
                //icon_number 값은 글의 번호로 사용한다.
                C20_ItemsAll item = new C20_ItemsAll
                        (
                                contentIdSplit[i], ""+ number++
                                , contentSplit[i].replace("<space>", "\n")
                                , authorSplit[i].replace("<space>", "\n")
                                , annotationSplit[i].replace("<space>", "\n")
                                , favoriteSplit[i]
                        );

                //C20_ItemsAll 값을 최종적으로 리스트(resultDB)에 담는다.
                resultDB.add(item);
            }
        } else {
            //즐겨찾기 쿼리 결과가 null 혹은 0일 경우에는 resultDB에 null 값을 넣는다.
            C20_ItemsAll item = new C20_ItemsAll(null, null, null, null, null, null);
            resultDB.add(item);
        }
        return resultDB;
    }

    //내가 좋아하는 글의 총 수 구하기
    int favoriteCount() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select count(*) from PHILOSOPHY where favorite = 1", null);
        int count = 0;
        while (cursor.moveToNext()) {
            count = cursor.getInt(0);
        }
        return count;
    }

    //내가 좋아하는 글의 아이콘 변경을 위한 업데이트 쿼리 실행 (DB의 favorite 컬럼 값 변경)
    void favoriteUpdate(int favoriteValue, int contentId) {
        SQLiteDatabase db = getWritableDatabase();

        //favoriteValue 값에 따라 조건문을 나눈다.
        if (favoriteValue == 0) {
            //contentId 를 기준으로 favoriteValue 가 0이면 1로 변경
            db.execSQL("update PHILOSOPHY set FAVORITE = " + 1 + " where ID = " + contentId + ";");
        } else {
            //contentId 를 기준으로 favoriteValue 가 1이면 0으로 변경
            db.execSQL("update PHILOSOPHY set FAVORITE = " + 0 + " where ID = " + contentId + ";");
        }

        //DB 닫기 (꼭 닫아 줘야 함)
        db.close();
    }
}