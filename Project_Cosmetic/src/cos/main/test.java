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
		//< �Ǽ��� ȭ��ǰ ����Ʈ >
cosAdd[0][0] =new Cosmetic( "��� �����ƺ��� ������ ������" , 29720 , "���" , "���� ������ ���缺������ �Ǻθ�  �ε巴�� ��ȣ���ִ� ������ �μ�" , "�Ǽ�" , "�μ�");

cosAdd[0][1] =new Cosmetic( "���� ���� ���̵�� �μ�" , 28000 , "����" , "�Ǻΰ� ���ų� �����Ÿ��� ��  �������� ����, ���а� ������ �����ְ� �����Ͽ� �����ϸ鼭�� ����� �Ǻη�!" , "�Ǽ�" , "�μ�");

cosAdd[0][2] =new Cosmetic( "������� ���" , 10500 , "������" , "�� ���, ��̼� 90.89% ������ �����ϰ� �۾Ƴ��� �������� ��̼� ���" , "�Ǽ�" , "��Ų");

cosAdd[0][3] =new Cosmetic( "�� ���� ��Ų" , 25900 , "����" , "������ ���� ����� ǰ�� ���� ���� ��ȿ�Ͽ� ���� �������� ������ �Ǻο� ������ ä��� ��Ƶδ� ���� ���� ��Ų" , "�Ǽ�" , "��Ų");

cosAdd[0][4] =new Cosmetic( "���̽�Ʈ�� ������ ��Ų" , 23100 , "���̿���" , "�Ǻ� ���� �������� �����Ͽ� ������ ���� �Ǻ� ����� �ؼ����ִ� ������Ų" , "�Ǽ�" , "��Ų");

cosAdd[0][5] =new Cosmetic("�Ƹ��� ���� ��Ʈ�� �� ���̽��� �μ�" , 16000 , "���ǹٽ�" , "����� �Ƹ��� ���ϰ� ������ ��ȿ õ���������ڰ� ������ ä���ְ� ����ִ� ��� ��ȭ ���� ���� ����" , "�Ǽ�" , "�μ�" );

cosAdd[0][4] =new Cosmetic("�þ���� ���ٽú� ���̽��� �μ�" , 16000 , "���ǹٽ�" , "�þ���Ϳ� ������ ��ȿ õ���������ڰ� �Ǻ� ������ ������ ä���ְ� ����ִ� 24�ð� ���� ���� ����" , "�Ǽ�", "�μ�");

cosAdd[0][6] =new Cosmetic("��Ʈ�� ����� ���̽��� ũ��" , 7500 , "�ϸ���" , "���Է� ���׳�(5%) ����, ������ ���� ���, ������, ��ĥ������ ���� �ɾ��Ͽ� �Ϸ� ���� �����ϰ� ������ �Ǻη� �����ִ� �ʰ����� ũ��" , "�Ǽ�" , "�μ�");

cosAdd[0][7] =new Cosmetic("�����̵� ���� ����ũ�� " , 9950 , "�ϸ���" , "�ΰ��ϰ� ������ �Ǻο� ����/���� ȿ���� �ִ� �Ǻ� �庮 ��ȭ ���ڱ� ũ��", "�Ǽ�" , "�μ�" );

cosAdd[0][8] =new Cosmetic( "��Ʈ�� ����� �μ�" , 9950 , "�ϸ���" , "�����ϰ� ��ĥ���� �ջ� �Ǻο� ��� ���� �������� �ִ� ������ ������ �μ�" , "�Ǽ�", "�μ�");

cosAdd[0][9] =new Cosmetic("��Ʈ�� ����� ũ��" , 9950 , "�ϸ���" , "�����ϰ� ��ĥ���� �ջ� �Ǻθ� ���� �ɾ��ϴ� ������ �ʰ����� ũ��" , "�Ǽ�" , "�μ�");

cosAdd[0][10] =new Cosmetic( "���̽�ó �����̵� ũ�� Ȧ������ �����" , 20300 , "������" , "��ƴ���� ���� �������� ưư�� �Ǻ� �庮�� ����� �ִ� ����ȭ ���� �庮 ũ�� (Ȧ������ ������ ��Ű��)" , "�Ǽ�" , "�μ�");

cosAdd[0][11] =new Cosmetic("���� ���ϵ� �̼��� ����" , 9800 ,"�ϸ���" , "�� ������ �ʿ� ���� ��꼺 ���ڱ� Ŭ��¡����" , "�Ǽ�" , "��Ų" );

cosAdd[0][12] =new Cosmetic("�� ���� ����ũ��" , 28000 , "����" , "���� ���� ���� ������ �޸��� �Ǻ� ����� �������� ���Ͽ� ���� �帣�� ���� �Ǻθ� �ϼ��ϴ� ���� ���� ũ��" , "�Ǽ�" , "�μ�" );

cosAdd[0][13] =new Cosmetic("�θ�ġ�� ��Ʈ�� ��Ų������" , 11200 , "������" , "�����ϰ� �޸��� �Ǻθ� �ǰ��ϰ� �����ϰ� �����ִ� ������ ��Ų" , "�Ǽ�" , "��Ų" );
//
cosAdd[0][14] =new Cosmetic("�������� ��������" , 38500 , "����" , "�ڿ� ��Ƽ����¡ ���� ���������� ������ ������ � �Ǻθ� ��ã���ִ� ������ ��Ƽ����¡ ����" , "�Ǽ�" , "�μ�" );

cosAdd[0][15] =new Cosmetic("���̿� ����Ʈ ����ũ ���ٽú� ����¡" , 35000 , "���̿���" , "�� ���� ��ġ�� �ջ�� �Ǻ� �������� �� �ð� ���� ������ �� ���ִ� ����Ʈ ����ũ" , "�Ǽ�" , "�μ�" );

cosAdd[0][16] =new Cosmetic("����Ʈ ���� ������" , 28000 , "�����" , "������ ������ ���߰� �Ǻθ� ��ȣ���ִ� ������" , "�Ǽ�" , "�μ�" );

cosAdd[0][17] =new Cosmetic("����Ʈ ���� ũ��" , 42000 , "�����" , "�Ǻ� �庮�� ��ȭ�ϰ� �����ְ� ���ٴ� ������ ũ��" , "�Ǽ�" , "�μ�" );

cosAdd[0][18] =new Cosmetic("ǻ��ȭ��Ʈ ��Ʈ���Ƽ�� ũ��" , 24500 , "������" , "ź�¹̹鸷�� �Ǻθ� ��ȣ�Ͽ� ������ ���� ����ȭ�Ǵ� �Ǻ� ĢĢ�԰� ź�����ϸ� ������ִ� ź�¹̹�ũ��" , "�Ǽ�" , "�μ�" );

cosAdd[0][19] =new Cosmetic("���̺� ����Ʈ ������" , 24500 , "���̿���" , "�Ǻΰ��� �ε巴�� �������ָ� �����ϰ� �Ų����� �Ǻη� ��Ƽ����¡ ź�� ������" , "�Ǽ�" , "��Ų" );

cosAdd[0][20] =new Cosmetic("ũ���� ���̽�������� �� ���̽�Ʈ" , 34000 , "������" , "�ε巴�� �����Ǿ� ǳ���� ���簨�� �Բ� �������� �����ϴ� �Ǽ� �Ǻο� ���̽��������" , "�Ǽ�" , "�μ�");

cosAdd[0][21] =new Cosmetic("RNA �Ŀ� ������ �� ������ ũ��" ,125000 ,"����������" , "���Ϸ� ���Ӿ��� ź���� ����÷��־�, �Ǻ��� ��ƴ�� ä���ִ� ź�� ũ��" , "�Ǽ�" ,"�μ�" );

cosAdd[0][22] =new Cosmetic("���̼� Ʈ��Ʈ��Ʈ Ŭ���� �μ�" , 61000 , "����������" , "������ �����̳�, ����� ���� �������� ��ȭ�ϰ� ������, �������� �ִ� �Ǻθ� �������� �ݴϴ�." , "�Ǽ�" , "�μ�" );

cosAdd[0][23] =new Cosmetic("���� ���� ������Ʈ ���� �� �μ�" , 64000 , "����" , "������ �ӱ��� ���� �����Ʈ�� ������ �Ǻο� �ٸ��� ���� ���� ���ϸ鼭 �Ǻ� �� ������ �Բ� �Ǻ����� ������ �� ����ݴϴ�." , "�Ǽ�" , "�μ�" );

cosAdd[0][24] =new Cosmetic("��-��Ʈ���� ���ٽú� ����Ʈ�� �μ�" , 58000 , "����Ƽ�δ�" , "�ݰ��� ���ڰ� ���ԵǾ� �Ǻθ� �۾Ƴ��� �Ų����� ���������ָ�, ������ �뷱���� ã���ִ� �����ڿ� �μ�" , "�Ǽ�" , "�μ�" );
cosAdd[0][25] =new Cosmetic("���̼� Ʈ��Ʈ��Ʈ Ŭ���� �μ�" , 68000 , "����������" , "������ �����̳�, ����� ���� �������� ��ȭ�ϰ� ������, �������� �ִ� �Ǻθ� �������� �ݴϴ�." , "�Ǽ�" , "�μ�" );

cosAdd[0][26] =new Cosmetic("���� ��Ƽ �ڷ�Ƽ�� ũ��" , 59900 , "Ű��" , "���� ����Ʈ ũ������ Ư���� Ʈ���� ���Ķ��� ��ġ Ʈ�� ���⹰, �罺���, ���Ʒ�� ���� �Ǻθ� ���� �����ϰ� �ε巴�� �ɾ��ϴµ� ������ �ݴϴ�." , "�Ǽ�" , "�μ�" );

cosAdd[0][27] =new Cosmetic("ť�Ĺ� ��� ���ڿ� ���� ���" , 26900 , "Ű��" , "����, ī���� �� ���� ��� ���⹰�� �����Ͽ� �ǰǼ�, �Ǽ� �Ǵ� �߰Ǽ� �Ǻο� ������ 40�� ������ ���ڿ� ���� ���� ����Դϴ�. �Ǻθ� �����ϰ� ���� ������ ���� ȿ�� �� ������ ��� ȿ���� �ݴϴ�." , "�Ǽ�" ,"��Ų" );

cosAdd[0][28] =new Cosmetic("�����Ŀ� ��ġ ũ��" , 113000 , "����������" , "�޸��� �Ǻ� �������� �ذ��ϰ� ���⸦ �ָ�, ������ �󱼼��� ����ִ� ��ġ�ϰ� ǳ���� ������ ũ���Դϴ�." , "�Ǽ�" , "�μ�" );

cosAdd[0][29] =new Cosmetic("��ȭ�� ��������" , 44000 , "��ȭ��" , "������ �����Ǿ� �Ǻθ� �ε巴�� �ٵ���ִ� �ѹ� ����" , "�Ǽ�" , "�μ�" );


//< �߼��� ȭ��ǰ ����Ʈ >
cosAdd[1][0] =new Cosmetic( "������ �Ŀ� ��Ų �����̳�", 19600 , "�����" , "������ ȿ������ ���� �������� ������ �Ǻθ� �������ִ� ������ Ÿ���� ��Ų" , "�߼�" , "��Ų");

cosAdd[1][1] =new Cosmetic( "û�� ������ �� ���� ��Ų" , 25000 , "���µ���" , "�Ӵ���� �ذ��ϴ� ���� �������ο��� ��Ų", "�߼�", "��Ų" );

cosAdd[1][2] =new Cosmetic( "�÷�Ʈ ���ۼ� ������ ��Ų �����" , 26600 , "���̿���" , "�Ĺ��ٱ⼼�����а� �̹麸�������� ������ ���� ��Ƽ����¡ ������" , "�߼�" , "��Ų");

cosAdd[1][3] =new Cosmetic( "�θ�ƽ ��Ų �����̳�" , 18900 , "��������" , "�鵵, ���� �� �ڱ� ���� �Ǻθ� �ε巴�� ������Ű��, �������� �Ǻο� ������ ���� ������ ������ �ִ� ��Ȥ���� ������ ��Ų" , "�߼�", "��Ų");

cosAdd[1][4] =new Cosmetic( "���� ������ ����¡ ������" , 21000 , "��������" , "������ �������� ���������� �ɾ��Ͽ� �Ǻθ� �����ϰ� ���������ִ� ����¡ ������" , "�߼�" , "�μ�");

cosAdd[1][5] =new Cosmetic( "���� ������ �μ�" , 9950 , "�ϸ���" , "�Ǻθ� �����ְ� �ǰ��ϰ� ���پ��ִ� ������� ������ �μ�" , "�߼�" , "�μ�" );

cosAdd[1][6] =new Cosmetic("û�� ���̽����� �μ�" , 36000 , "���µ���" , "�󱼺��� �߳����� �°����� �� ���� ���� �μ�" , "�߼�" , "�μ�" );

cosAdd[1][7] =new Cosmetic("���̿� ���̵�� ũ��" , 29400 , "���̿���" , "�Ǻο� źź�ϰ� ������ ä���ִ� ���̿� ���� ũ��" , "�߼�" , "�μ�" );

cosAdd[1][8] =new Cosmetic( "��� �������� �÷��̵�" , 17500 , "����" , "������ ���� �����ϰ� ������ �����ϰ� ����� �Ǻθ� �����ϰ� ��������� ���ϵ��� ��� �÷��̵�" , "�߼�" , "�μ�");

cosAdd[1][9] =new Cosmetic("���̽�Ʈ�� ������ ��Ų ���̵巹�̼�" , 24500 , "�����" , "�Ǻο� ���а� ������ �����Ͽ� �Ų��� �Ǻη� �����ִ� ���� �μ�" , "�߼�" , "��Ų" );

cosAdd[1][10] =new Cosmetic( "������ ���� ũ��" , 35000 , "����" , "������ ������ �����¸� ��° ��ȿ�� ���� ������ ��ȿ ���ע�� ������ ����þƴ���  3�� ȿ����(��ģ �Ǻ� ����+��Ǻ� �ɾ�+������ȣ)�ǰ��� ��Ǻθ� �ٽ�  ������ �ϴ� ������ ���� ũ��" , "�߼�" , "�μ�");

cosAdd[1][11] =new Cosmetic( "������ �뷱�� ������", 21700 , "�����" , "�ſ� ������ ��ĥ���� �Ǻο� ����� ���� �뷱���� �����ִ� ������ ������", "�߼�" , "�μ�");

cosAdd[1][12] =new Cosmetic("���̽�ó �����̵� ��Ų ������" , 11200 , "������" , "��Ʈ���� �Ǻ� �庮�� ��ȭ ���� �־� ��ƴ ���� �������� �����ϴ� ������ ��Ų" , "�߼�" , "��Ų" );

cosAdd[1][13] =new Cosmetic("���� �� �ʸ� ���" , 17500 , "����" , "��ģ �Ǻΰ��� �����ϰ� �Ų��ϰ� ������ �ִ� ���ϸ� ���� �ʸ� ���" , "�߼�" , "��Ų" );

cosAdd[1][14] =new Cosmetic("Ÿ�� ������ ���ٽú� ũ��" , 45500 , "�����" , "�Ǻ� ��ȭ�� �ӵ��� ���߾� ź�� �ְ� ������ � ���̽��� ���ٴ� ���� ũ��" , "�߼�" , "�μ�" );

cosAdd[1][15] =new Cosmetic("ȭ��Ʈ�� ������ ��Ų ��̳ʽ�" , 28000 , "���̿���" , "�Ǻθ� ��ȣ�ϰ� ������ ���� �ϴ� ȭ��Ʈ�� ������" , "�߼�" , "��Ų" );

cosAdd[1][16] =new Cosmetic("ǻ�� ����Ƽ�� ���" , 9100 , "������" , "�Ǻ� ��Ʈ������ ���� ��ȭ�� ��ģ �Ǻο� ������ �����Ͽ� ���������ִ� �ΰ��� �Ǻθ� ���� ���ڱ� ���" , "�߼�" , "��Ų");

cosAdd[1][17] =new Cosmetic("��Ż �ַ�� ũ��" , 24500 , "������" , "�Ǻ� �ŷ��� ����ø��� 3D��Ż ��Ƽ����¡ ũ��ź��,����,�ָ�, �̹�,�׻�ȭ���� �ѹ���" , "�߼�" , "�μ�" );

cosAdd[1][18] =new Cosmetic("���Ʒ�δ� ������" , 21000 , "���̿���" , "���Ʒ�л��� �����Ǿ� �����ϰ� �Ų��� �Ǻη� ���پ� �ִ� ���� ��Ų" , "�߼�" , "��Ų" );

cosAdd[1][19] =new Cosmetic("������ ��Ʈ�� �Ŀ� ũ��" , 25900 , "������" , "�ﰢ������ ź���� �ο��԰� ���ÿ� �Ǻ� ��ȣ �庮�� ��ȭ���ִ� ��Ŭ&�۹� 2�� ��� ũ��" , "�߼�" , "��Ų" );

cosAdd[1][20] =new Cosmetic("������ ��Ʈ�� ������" , 16800 , "������" , "�ε巴�� ������ �������� ������ ����¡�ɾ��� �⺻�� ưư�� ����ִ� ������", "�߼�" , "�μ�" );

cosAdd[1][21] =new Cosmetic("���� ���ϵ� ũ��" , 17500 , "����" , "���� �ΰ������� �Ǻε� ���ϰ� �����ϰ� �ɾ��� �ִ� ���ڱ� ���� ũ��" , "�߼�" , "�μ�" );

cosAdd[1][22] =new Cosmetic( "������ ��Ʈ�� ��Ų ������" , 15400 , "������" , "�Ǻ� ���� �Ų����� �����Ͽ� ȿ�� ������ ������ ������ ǳ���� �������� ��Ƽ����¡ ��Ų" , "�߼�" , "��Ų");

cosAdd[1][23] =new Cosmetic("���Ʒ�δ� ������" , 22400 , "���̿���" , "���Ʒ�л��� �����Ǿ� �����ϰ� �Ų��� �Ǻη� ���پ� �ִ� ���� �μ�" , "�߼�" , "�μ�");

cosAdd[1][24] =new Cosmetic("���� ��Ų" , 42000 , "����" , "�Ǻ���� ���� ���� �����ϰ� �������ִ� ������ ��Ų" , "�߼�" , "��Ų");
cosAdd[1][25] =new Cosmetic("ǻ��ȭ��Ʈ ��Ʈ���Ƽ�� ������" , 16800 , "������" , "�Ǻ� ĢĢ���� �����ְ� �������� ä���ִ� ���� ź�¹̹� �μ�" , "�߼�" , "�μ�" );

cosAdd[1][26] =new Cosmetic("����Ʈ ���� ��Ų �����̳�" , 26600 , "�����" , "�����Ӿ��� ������ ������ ���� ä��� ������ ��Ų" , "�߼�" , "��Ų" );
//
cosAdd[1][27] =new Cosmetic("���� ������" , 49000 , "����" , "�Ǻ� ������ �Ͽ����� ��Ȱ�ϰ� ȸ�������ִ� �����̾� �ѹ� �μ�" , "�߼�" , "�μ�" );

cosAdd[1][28] =new Cosmetic("���̺� ����Ʈ ũ��" , 38500 , "���̿���" , "�����ϰ� �����Ǿ� �����ϰ� ź�� ��ġ�� �Ǻη� �����ִ� �� Ƽ����¡ ź�� ũ��" , "�߼�" , "�μ�" );

cosAdd[1][29] =new Cosmetic("���� ���� ��Ƽ ��Ƽũ��" , 11200 , "�Ƹ�����" , "�ѹ��� �������� ũ��, ��������ũ�� 3in1 ������ ���ο� �� Ƽ ũ��" , "�߼�" , "�μ�" );


//<������ ȭ��ǰ ����Ʈ >

cosAdd[2][0] =new Cosmetic( "��� �������� ���" , 15400 , "����" , "�Ǻ� ����ȿ���� �ִ� ����� �Ǻθ� �����ϰ� �����ְ� �Ǻΰ��� �ε巴�� �����ϴ� ���ϵ��� ��� ���" , "����" , "��Ų");

cosAdd[2][1] =new Cosmetic( "û�� ���ο� ũ��" , 32000 , "���µ���" , "���к����� �����Ǻο� ���´� �ְ����� ���ο�ũ��" , "����" , "�μ�" );

cosAdd[2][2] =new Cosmetic( "���̽�ó �����̵� ũ��" , 20300 , "������" , "��ƴ ���� ���� ������ ���� ưư�� �Ǻ� �庮�� ����� �ִ� ����ȭ ���� �庮 ũ��" , "����" , "�μ�");

cosAdd[2][3] =new Cosmetic( "���͹�ũ �� ũ�� " , 25900 , "�����" , "�Ϸ����� �����ϰ� ������ �������� ����� �� Ÿ�� ����ũ��" , "����" , "�μ�");

cosAdd[2][4] =new Cosmetic( "��� ���� Ŭ�� ���" , 12600 , "������" , "������� �� ���� ������ �������ְ� ��� ���� ȿ���� �پ ��� ��� Ŭ���� ��� (õ���������� 99.3% ����)" , "����" , "��Ų");

cosAdd[2][5] =new Cosmetic( "���̽�ó �����̵� ����Ʈ ũ��" , 20300, "������", "��ƴ ���� ���� ������ ���� ưư�� �Ǻ� �庮�� ����� �ִ� ����� Ÿ���� ����ȭ ���� �庮 ũ��" , "����" , "�μ�");

cosAdd[2][6] =new Cosmetic( "�÷ζ� ���̵�� ������" , 12600 , "������" ,"���а� ��ġ�� �߸����� ���� ���������� ������ �Ǻο� �ﰢ������ �������� ���ϴ� ���� �뷱�� ������" , "����" , "�μ�");

cosAdd[2][7] =new Cosmetic( "�÷ζ� ���̵�� ũ��" , 15400 , "������" , "����� ���� �ؽ�ó�� ������ ���� �������� ���� ���ӽ����ִ� ���� ���� ũ��" , "����" , "�μ�" );

cosAdd[2][8] =new Cosmetic( "������ ī�� ���" , 18200 , "�����" , "�Ǻ� ������ �뷱���� �����ְ�, ����ϰ� ������ �Ǻη� ������ִ� ���� ���� ���" , "����" , "��Ų");

cosAdd[2][9] =new Cosmetic( "���� ���� ��Ƽ���� ���" , 17500 , "���̿���" , "���� ���⹰�� ����� û���ϰ� �ɾ��ϰ�, �Ŀ���� ��� �Ӱ� ���� ���� ������ �����Ͽ� �Ϸ�����  ������ �Ǻη� ���������ִ� ���" , "����" , "��Ų" );

cosAdd[2][10] =new Cosmetic( "AC �뷱�� ���" , 9100, "������" , "���� ������ ������ �ε巴�� �۾� ���� �����ϰ� �к�� ������ �ɾ��� �־� �Ǻθ� û���ϰ� �������ִ� ���� �ַ�� ���" , "����" , "��Ų");

cosAdd[2][11] =new Cosmetic( "AC �뷱�� ������" ,10500 , "������" , "�Ǻ� �������� �뷱���� �������ָ� ���� ���� ���� �����Ͽ� �� ��� ���� ����ϰ� �������� �ο��ϴ� ���� �ַ�� ������" ,"����" , "�μ�" );

cosAdd[2][12] =new Cosmetic("���۹���Ż ũ�� ���̿� ������Ʈ" , 70000 , "���̿���", "���̿� ����Ƽ���̵�Ⱑ ���ôٹ�������  �Ͼ�� �Ǻγ�ȭ������ ��ƴ���� �ɾ��ϴ� ��Ż  ��Ƽ����¡ ũ��" , "����" , "�μ�");

cosAdd[2][13] =new Cosmetic("����Ʈ���� ���" ,21000, "���̿���", "��ģ �Ǻθ� ������Ű�� �Ǻ� ��ȭȿ���� �ο��ϴ� Ʈ���� �Ǻο� ���" , "����" , "��Ų" );

cosAdd[2][14] =new Cosmetic( "����Ʈ���� ������", 22400 , "������" , "�Ǻ��� ��Ʈ������ ��ȭ�ϰ� �Ǻ��庮�� ��ȭ�Ͽ� �ǰ��� �Ǻη� ���پ��ִ� Ʈ���� �Ǻο� ������" ,"����" , "�μ�");

cosAdd[2][15] =new Cosmetic( "������ �� ���" , 10500 , "������" , "�Ǻ� ǥ���� ���ʿ��� ������ �ÿ��ϰ� �۾Ƴ��� �Ų����� ������ �Ǻη� ���پ��ִ� ������ ���� ���� ���" , "����" , "��Ų");
//
cosAdd[2][16] =new Cosmetic("���� ����� ��Ų ����" , 19600 , "���̿���" , "�Ǻο� �����ϴ� Į�� �̿� ���� ����, �Ǻθ� �����ϰ� ���� �ִ� ���ǵ� ���� ���� ���" , "����" , "��Ų");

cosAdd[2][17] =new Cosmetic("���� ���ٽú� ���̽�ó ũ��" , 26600 , "���̿���" , "�Ǻ� ������ ���� �������� ��ȭ�Ͽ� �ǰ��� �Ǻη� ���پ� �ִ� ���� �庮 �ɾ� ũ��", "����" , "�μ�" );

cosAdd[2][18] =new Cosmetic("ȭ��Ʈ�� ��Ų �����̳�" , 21000 , "�����" , "������ ����ϰ� �Ǻο� �����Ǿ� ���� �Ǻ������� �������� �ִ� ���� ȭ��Ʈ�� ��Ų" , "����" , "��Ų" );

cosAdd[2][19] =new Cosmetic("ȭ��Ʈ�� ������" , 23100 , "�����" , "����� ������ �����Ǿ� �Ǻθ� ȯ�ϰ� �����ϰ� �����ִ� �� �� ȭ��Ʈ�� ������" , "����" , "�μ�" );

cosAdd[2][20] =new Cosmetic("ȭ��Ʈ �÷��� ���� �������� ũ��" , 35000 , "�����" , "�Ǻο� ���б�ä�����ѵ� ������ ��� �Ǻθ� ��ȣ�ϴ� ���� �� ȭ��Ʈ�� ũ��" , "����" , "�μ�" );

cosAdd[2][21] =new Cosmetic("ȭ��Ʈ�� ���ũ��" , 26600 , "�����" , "�ٸ��� ��� ����� ĢĢ�� �Ǻ����� ȯ�ϰ� ������� �ִ� ������ ������ ���� ȭ��Ʈ�� ��� ũ��" , "����" , "�μ�" );

cosAdd[2][22] =new Cosmetic("ȭ��Ʈ�� ũ��" , 42000 , "���̿���" , "ĢĢ�� �Ǻ���� ��Ƽ�� �ɾ��ϰ� �Ų����� �����ִ� �Ǻθ� ���پ��ִ� ȭ��Ʈ�� ũ��" , "����" , "�μ�" );

cosAdd[2][23] =new Cosmetic("����Ʈ���� ũ��" , 24500 , "���̿���" , "�ұ����� �Ǻ� ��.���� �뷱���� ���߾��ְ� ���� �Ǻθ� �� ȣ�ϴ� Ʈ���� �Ǻο� ũ��" , "����" , "�μ�" );

cosAdd[2][24] =new Cosmetic("���̺� ����Ʈ ������" , 25900 , "���̿���" , "������ �뷱���� �����ָ� �����ϰ� �Ų����� �Ǻη� ���� �� �� ��Ƽ����¡ ź�� ������" , "����" , "�μ�" );
cosAdd[2][25] =new Cosmetic("���� ��� �ν긣" , 55000 , "����" , "���� ����(��̼�)�� �����Ͽ� �Ǻθ� �ε巴�� �����ϰ� ���پ��ִ� ��� �Ǻο� ���" , "����" , "��Ų" );

cosAdd[2][26] =new Cosmetic("���� ������Ʈ ������ �� �μ�" , 65000 , "����" , "��ƿ C ȭ��Ʈ�� ������ �����ϰ� ȯ�� ���б� �Ǻθ� �ϼ�" , "����" , "�μ�" );

cosAdd[2][27] =new Cosmetic("��� ������ ���" , 53000 , "����" , "�����ϰ� ǳ���� ���� ����� �ؽ��İ� �Ǻθ� �Ų����� �����ϰ� ���ش�. �Ƹ��, ����⹰, ȿ�� ���⹰, �� ������ �Ǻο� ���� �� �ε巯���� �����մϴ�." , "����" , "��Ų");

cosAdd[2][28] =new Cosmetic("��-��Ʈ���� ũ��" , 120000 , "����Ƽ�δ�" , "�Ǻθ� ǳ���� ������ �������ִ� ����Ƽ�δ��� ����Ʈ���� ����ũ��" , "����" , "�μ�" );

cosAdd[2][29] =new Cosmetic("ĸ�� ��Ż �帲 ��Ų" , 115000 , "���" , "Ư���� ���, ����� �����̴� �Ű��� ��Ż ��Ƽ�ɾ�� ���� �ӵ��� �Ǻ� ������ �Ƹ��ٿ��� ��ã���־� ȭ��� ���� �ڿ������� ���� ������ �� �ֽ��ϴ�. ���Ҿ� ���������� ������ ������ ���� ������ �Ǻΰ����� ������ �ݴϴ�." , "����" , "��Ų" );
		
 
		 //����Ʈ ���
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
