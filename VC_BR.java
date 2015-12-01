	import java.awt.Graphics;
	import java.awt.Image;
	import java.awt.image.BufferedImage;
	import java.io.File;
	import java.io.*;
	import java.awt.image.Raster;
	import javax.imageio.ImageIO;

	public class VC_BR {
	    
	    
	    public static void 	main(String args[])throws IOException
	    {
                String fname=args[0]; String type=args[1]; String br=args[2];
                System.out.println(fname);
                System.out.println(type);
	        Image image = ImageIO.read(new File(fname+"."+type));
	        /*BufferedImage img = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);*/
	        BufferedImage img = (BufferedImage)image;
	        int w = img.getWidth();
	        int h = img.getHeight();
                int ws=0, bs=0;
	        /*int values;
	        MersenneTwister rand = new MersenneTwister();
	        
	        int[][] array = new int[w][h];
	        int[][] value=new int[w][h];
	        int[][] S1=new int[w][h];
	        int[][] S2=new int[w][h];
	        int[][] S3=new int[w][h];*/
	        //Raster raster = ((BufferedImage)image).getData();
	        /*for (int j = 0; j < w; j++)
	        {
	            for (int k = 0; k < h; k++)
	            {
                        if((img.getRGB(j,k)+16777216)>(-1*((img.getRGB(j,k)+1)))) 
	                img.setRGB(j,k, -1);
                        else
                        img.setRGB(j,k, -16777216);
                        //img.setRGB(j,k, img.getRGB(j,k));
	            }
	        }*/
	        /*File outputfile2 =  new   File ("test"+"."+type);
	            ImageIO .write(img,type,outputfile2);*/
               BufferedImage img1 = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
               BufferedImage img2 = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
	        for (int j = 0; j < w; j+=2)
	        {
	            for (int k = 0; k < h; k+=2)
	            {
                        if(img.getRGB(j,k)==-1)
                        { 
                        if(ws%6==0)
                        {
	                img1.setRGB((j+1),(k+1), -1);
                        img1.setRGB((j),(k+1), -16777216);
                        img1.setRGB((j+1),(k), -1);
                        img1.setRGB((j),(k), -16777216);
                        img2.setRGB((j+1),(k+1), -1);
                        img2.setRGB((j),(k+1), -16777216);
                        img2.setRGB((j+1),(k), -1);
                        img2.setRGB((j),(k), -16777216);
                        }
                        else if(ws%6==1)
                        {
	                img1.setRGB((j+1),(k+1), -16777216);
                        img1.setRGB((j),(k+1), -1);
                        img1.setRGB((j+1),(k), -16777216);
                        img1.setRGB((j),(k), -1);
                        img2.setRGB((j+1),(k+1), -16777216);
                        img2.setRGB((j),(k+1), -1);
                        img2.setRGB((j+1),(k), -16777216);
                        img2.setRGB((j),(k), -1);
                        }
                        else if(ws%6==2)
                        {
	                img1.setRGB((j+1),(k+1), -16777216);
                        img1.setRGB((j),(k+1), -16777216);
                        img1.setRGB((j+1),(k), -1);
                        img1.setRGB((j),(k), -1);
                        img2.setRGB((j+1),(k+1), -16777216);
                        img2.setRGB((j),(k+1), -16777216);
                        img2.setRGB((j+1),(k), -1);
                        img2.setRGB((j),(k), -1);
                        }
                        else if(ws%6==3)
                        {
	                img1.setRGB((j+1),(k+1), -1);
                        img1.setRGB((j),(k+1), -1);
                        img1.setRGB((j+1),(k), -16777216);
                        img1.setRGB((j),(k), -16777216);
                        img2.setRGB((j+1),(k+1), -1);
                        img2.setRGB((j),(k+1), -1);
                        img2.setRGB((j+1),(k), -16777216);
                        img2.setRGB((j),(k), -16777216);
                        }
                        else if(ws%6==4)
                        {
	                img1.setRGB((j+1),(k+1), -1);
                        img1.setRGB((j),(k+1), -16777216);
                        img1.setRGB((j+1),(k), -16777216);
                        img1.setRGB((j),(k), -1);
                        img2.setRGB((j+1),(k+1), -1);
                        img2.setRGB((j),(k+1), -16777216);
                        img2.setRGB((j+1),(k), -16777216);
                        img2.setRGB((j),(k), -1);
                        }
                        else if(ws%6==5)
                        {
	                img1.setRGB((j+1),(k+1), -16777216);
                        img1.setRGB((j),(k+1), -1);
                        img1.setRGB((j+1),(k), -1);
                        img1.setRGB((j),(k), -16777216);
                        img2.setRGB((j+1),(k+1), -16777216);
                        img2.setRGB((j),(k+1), -1);
                        img2.setRGB((j+1),(k), -1);
                        img2.setRGB((j),(k), -16777216);
                        }
                        ws++;
                        }
                        else
                        {
                        if(bs%6==0)
                        {
	                img1.setRGB((j+1),(k+1), -1);
                        img1.setRGB((j),(k+1), -16777216);
                        img1.setRGB((j+1),(k), -1);
                        img1.setRGB((j),(k), -16777216);
                        img2.setRGB((j+1),(k+1), -16777216);
                        img2.setRGB((j),(k+1), -1);
                        img2.setRGB((j+1),(k), -16777216);
                        img2.setRGB((j),(k), -1);
                        }
                        else if(bs%6==1)
                        {
	                img1.setRGB((j+1),(k+1), -16777216);
                        img1.setRGB((j),(k+1), -1);
                        img1.setRGB((j+1),(k), -16777216);
                        img1.setRGB((j),(k), -1);
                        img2.setRGB((j+1),(k+1), -1);
                        img2.setRGB((j),(k+1), -16777216);
                        img2.setRGB((j+1),(k), -1);
                        img2.setRGB((j),(k), -16777216);
                        }
                        else if(bs%6==2)
                        {
	                img1.setRGB((j+1),(k+1), -16777216);
                        img1.setRGB((j),(k+1), -16777216);
                        img1.setRGB((j+1),(k), -1);
                        img1.setRGB((j),(k), -1);
                        img2.setRGB((j+1),(k+1), -1);
                        img2.setRGB((j),(k+1), -1);
                        img2.setRGB((j+1),(k), -16777216);
                        img2.setRGB((j),(k), -16777216);
                        }
                        else if(bs%6==3)
                        {
	                img1.setRGB((j+1),(k+1), -1);
                        img1.setRGB((j),(k+1), -1);
                        img1.setRGB((j+1),(k), -16777216);
                        img1.setRGB((j),(k), -16777216);
                        img2.setRGB((j+1),(k+1), -16777216);
                        img2.setRGB((j),(k+1), -16777216);
                        img2.setRGB((j+1),(k), -1);
                        img2.setRGB((j),(k), -1);
                        }
                        else if(bs%6==4)
                        {
	                img1.setRGB((j+1),(k+1), -1);
                        img1.setRGB((j),(k+1), -16777216);
                        img1.setRGB((j+1),(k), -16777216);
                        img1.setRGB((j),(k), -1);
                        img2.setRGB((j+1),(k+1), -16777216);
                        img2.setRGB((j),(k+1), -1);
                        img2.setRGB((j+1),(k), -1);
                        img2.setRGB((j),(k), -16777216);
                        }
                        else if(bs%6==5)
                        {
	                img1.setRGB((j+1),(k+1), -16777216);
                        img1.setRGB((j),(k+1), -1);
                        img1.setRGB((j+1),(k), -1);
                        img1.setRGB((j),(k), -16777216);
                        img2.setRGB((j+1),(k+1), -1);
                        img2.setRGB((j),(k+1), -16777216);
                        img2.setRGB((j+1),(k), -16777216);
                        img2.setRGB((j),(k), -1);
                        }
                        bs++;
                        }
                        //img.setRGB(j,k, img.getRGB(j,k));
	            }
	        }
               File outputfile3 =  new   File ("VC_"+br+"_Share1"+"."+type);
	            ImageIO .write(img1,type,outputfile3);
               File outputfile4 =  new   File ("VC_"+br+"_Share2"+"."+type);
	            ImageIO .write(img2,type,outputfile4);
                BufferedImage img3 = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
	        for (int j = 0; j < w; j++)
	        {
	            for (int k = 0; k < h; k++)
	            {
                        if(img1.getRGB(j,k) == -16777216 || img2.getRGB(j,k) == -16777216)
                        img3.setRGB(j,k,-16777216);
                        else 
                        img3.setRGB(j,k,-1);
                    }
                }
                File outputfile5 =  new   File ("VC_"+br+"_Final"+"."+type);
	            ImageIO .write(img3,type,outputfile5);
	    }

	}

