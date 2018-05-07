package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;

public class CheckCodeServlet extends HttpServlet {

	String str = "abcedfghijklmnopqrstuvwxyzABCEDFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private Random random = new Random();

	// ����һ���������ܹ��������4���ַ�
	public String getStr() {
		String s = "";

		int len = str.length(); // �ַ����ĳ���
		for (int i = 0; i < 4; i++) {
			s += str.charAt(random.nextInt(len));
		}
		return s;
	}

	// �������������ɫ�ķ���
	public Color getColor() {
		int red = random.nextInt(256);
		int green = random.nextInt(256);
		int blue = random.nextInt(256);
		Color color = new Color(red, green, blue);
		return color;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��Ϊa������get�������Դ���д��doGet������
		// ��һ�����
		BufferedImage image = new BufferedImage(70, 30,
				BufferedImage.TYPE_INT_RGB);
		// ����
		Graphics pen = image.getGraphics();

		pen.setColor(Color.white);

		// ��һ������
		pen.fillRect(0, 0, 70, 30);

		pen.setFont(new Font("΢���ź�", Font.BOLD, 20));
		// ���ĸ��ַ�д��ͼƬ��
		String msg = getStr();
		//�����ɵ���֤�룬���뵽session��Χ��
		HttpSession session=request.getSession();
		session.setAttribute("autoCode", msg);
		
		for (int i = 0; i < 4; i++) {
            pen.setColor(getColor());
			pen.drawString(msg.charAt(i) + "", i * 15 + 5, 20);

		}

		// ��response�����л�ȡ��һ����������ܹ������õ�ͼƬ���ݸ��ͻ���
		ServletOutputStream sos = response.getOutputStream();

		ImageIO.write(image, "png", sos);

		sos.flush();
		sos.close();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}

}