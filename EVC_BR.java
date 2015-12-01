	import java.awt.Graphics;
	import java.awt.Image;
	import java.awt.image.BufferedImage;
	import java.io.File;
	import java.io.*;
	import java.awt.image.Raster;
	import javax.imageio.ImageIO;

	public class EVC_BR {
	    
	    
	    public static void 	main(String args[])throws IOException
	    {
                String fname=args[0]; String type=args[1];String f1=args[2]; String f2=args[3];
                System.out.println(fname);
                System.out.println(type);
	        Image image = ImageIO.read(new File(fname+"."+type));
                Image i1 = ImageIO.read(new File(f1+"."+type));
                Image i2 = ImageIO.read(new File(f2+"."+type));
	        /*BufferedImage img = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);*/
	        BufferedImage img = (BufferedImage)image;
                BufferedImage im1 = (BufferedImage)i1;
                BufferedImage im2 = (BufferedImage)i2;
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
                        System.out.println(img.getRGB(j,k));
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
                        img1.setRGB((j+1),(k+1), im1.getRGB(j+1,k+1));
                        img1.setRGB((j),(k+1), im1.getRGB(j,k+1));
                        img1.setRGB((j+1),(k), im1.getRGB(j+1,k));
                        img1.setRGB((j),(k), im1.getRGB(j,k));
                        img2.setRGB((j+1),(k+1), im2.getRGB(j+1,k+1));
                        img2.setRGB((j),(k+1), im2.getRGB(j,k+1));
                        img2.setRGB((j+1),(k), im2.getRGB(j+1,k));
                        img2.setRGB((j),(k), im2.getRGB(j,k));
                    }
                  }
               for (int j = 0; j < w; j+=2)
	        {
	            for (int k = 0; k < h; k+=2)
	            {
                      if(img.getRGB(j,k)==-16777216)
                      {
                          if(img1.getRGB(j,k)!=-16777216 && img2.getRGB(j,k)!=-16777216)
                          {
                              img1.setRGB(j,k,-16777216);
                              img1.setRGB(j,k+1,-16777216);
                              img2.setRGB(j+1,k,-16777216);
                              img2.setRGB(j+1,k+1,-16777216);
                          }
                     }
                     else
                     {
                          if(img1.getRGB(j,k)!=-1)
                          {
                              img1.setRGB(j,k,-1);
                              img1.setRGB(j,k+1,-1);
                          }
                           if(img2.getRGB(j,k)!=-1)
                          {
                              img2.setRGB(j,k,-1);
                              img2.setRGB(j,k+1,-1);
                          }
                       }
                   }
                  }
                              
               /*for (int j = 0; j < w; j++)
	        {
	            for (int k = 0; k < h; k++)
	            {
                     if(img.getRGB(j,k)!=img1.getRGB(2*j,2*k))
                     {
                         if(img.getRGB(j,k)==-1)
                         {
                             if((j+k)%6==0)
                             {
                             img1.setRGB(2*j,2*k,-1);
                             img1.setRGB(2*j,2*k+1,-1);
                             }
                             else if((j+k)%6==1)
                             {
                             img1.setRGB(2*j,2*k,-1);
                             img1.setRGB(2*j+1,2*k,-1);
                             }
                             else if((j+k)%6==2)
                             {
                             img1.setRGB(2*j+1,2*k+1,-1);
                             img1.setRGB(2*j+1,2*k,-1);
                             }
                             else if((j+k)%6==3)
                             {
                             img1.setRGB(2*j+1,2*k+1,-1);
                             img1.setRGB(2*j,2*k+1,-1);
                             }
                             else if((j+k)%6==4)
                             {
                             img1.setRGB(2*j+1,2*k+1,-1);
                             img1.setRGB(2*j,2*k,-1);
                             }
                             else if((j+k)%6==5)
                             {
                             img1.setRGB(2*j,2*k+1,-1);
                             img1.setRGB(2*j+1,2*k,-1);
                             }
                         }
                         else
                             {
                             if((j+k)%6==0)
                             {
                             img1.setRGB(2*j,2*k,-16777216);
                             img1.setRGB(2*j,2*k+1,-16777216);
                             }
                             else if((j+k)%6==1)
                             {
                             img1.setRGB(2*j,2*k,-16777216);
                             img1.setRGB(2*j+1,2*k,-16777216);
                             }
                             else if((j+k)%6==2)
                             {
                             img1.setRGB(2*j+1,2*k+1,-16777216);
                             img1.setRGB(2*j+1,2*k,-16777216);
                             }
                             else if((j+k)%6==3)
                             {
                             img1.setRGB(2*j+1,2*k+1,-16777216);
                             img1.setRGB(2*j,2*k+1,-16777216);
                             }
                             else if((j+k)%6==4)
                             {
                             img1.setRGB(2*j+1,2*k+1,-16777216);
                             img1.setRGB(2*j,2*k,-16777216);
                             }
                             else if((j+k)%6==5)
                             {
                             img1.setRGB(2*j,2*k+1,-16777216);
                             img1.setRGB(2*j+1,2*k,-16777216);
                             }
                         }
                     }
                     if(img.getRGB(j,k)!=img2.getRGB(2*j,2*k))
                     {
                         if(img.getRGB(j,k)==-1)
                         {
                             if((j+k)%4==0)
                             {
                             img2.setRGB(2*j,2*k,-1);
                             img2.setRGB(2*j,2*k+1,-1);
                             }
                             else if((j+k)%4==1)
                             {
                             img2.setRGB(2*j,2*k,-1);
                             img2.setRGB(2*j+1,2*k,-1);
                             }
                             else if((j+k)%4==2)
                             {
                             img2.setRGB(2*j+1,2*k+1,-1);
                             img2.setRGB(2*j+1,2*k,-1);
                             }
                             else if((j+k)%4==3)
                             {
                             img2.setRGB(2*j+1,2*k+1,-1);
                             img2.setRGB(2*j,2*k+1,-1);
                             }
                             else if((j+k)%6==4)
                             {
                             img2.setRGB(2*j+1,2*k+1,-1);
                             img2.setRGB(2*j,2*k,-1);
                             }
                             else if((j+k)%6==5)
                             {
                             img2.setRGB(2*j,2*k+1,-1);
                             img2.setRGB(2*j+1,2*k,-1);
                             }
                         }
                         else
                              {
                             if((j+k)%4==2)
                             {
                             img2.setRGB(2*j,2*k,-16777216);
                             img2.setRGB(2*j,2*k+1,-16777216);
                             }
                             else if((j+k)%4==3)
                             {
                             img2.setRGB(2*j,2*k,-16777216);
                             img2.setRGB(2*j+1,2*k,-16777216);
                             }
                             else if((j+k)%4==0)
                             {
                             img2.setRGB(2*j+1,2*k+1,-16777216);
                             img2.setRGB(2*j+1,2*k,-16777216);
                             }
                             else if((j+k)%4==1)
                             {
                             img2.setRGB(2*j+1,2*k+1,-16777216);
                             img2.setRGB(2*j,2*k+1,-16777216);
                             }
                             else if((j+k)%6==5)
                             {
                             img2.setRGB(2*j+1,2*k+1,-16777216);
                             img2.setRGB(2*j,2*k,-16777216);
                             }
                             else if((j+k)%6==4)
                             {
                             img2.setRGB(2*j,2*k+1,-16777216);
                             img2.setRGB(2*j+1,2*k,-16777216);
                             }
                         }
                     }
                    }
                 }*/
                     
                /*int c1=-1,c2=-1;
	        for (int j = 0; j < w; j++)
	        {
	            for (int k = 0; k < h; k++)
	            {
                        if(img.getRGB(j,k)==-1)
                        { 
                        if(im1.getRGB(j,k)==-1)
                        c1=16777216;
                        else
                        c1=im1.getRGB(j,k);
                        if(im2.getRGB(j,k)==-1)
                        c2=16777216;
                        else
                        c2=im2.getRGB(j,k);
                        if(ws%6==0)
                        {
	                img1.setRGB((2*j+1),(2*k+1), -1);
                        img1.setRGB((2*j),(2*k+1), c1);
                        img1.setRGB((2*j+1),(2*k), -1);
                        img1.setRGB((2*j),(2*k), c1);
                        img2.setRGB((2*j+1),(2*k+1), -1);
                        img2.setRGB((2*j),(2*k+1), c2);
                        img2.setRGB((2*j+1),(2*k), -1);
                        img2.setRGB((2*j),(2*k), c2);
                        }
                        else if(ws%6==1)
                        {
	                img1.setRGB((2*j+1),(2*k+1), c1);
                        img1.setRGB((2*j),(2*k+1), -1);
                        img1.setRGB((2*j+1),(2*k), c1);
                        img1.setRGB((2*j),(2*k), -1);
                        img2.setRGB((2*j+1),(2*k+1), c2);
                        img2.setRGB((2*j),(2*k+1), -1);
                        img2.setRGB((2*j+1),(2*k), c2);
                        img2.setRGB((2*j),(2*k), -1);
                        }
                        else if(ws%6==2)
                        {
	                img1.setRGB((2*j+1),(2*k+1), c1);
                        img1.setRGB((2*j),(2*k+1), c1);
                        img1.setRGB((2*j+1),(2*k), -1);
                        img1.setRGB((2*j),(2*k), -1);
                        img2.setRGB((2*j+1),(2*k+1), c2);
                        img2.setRGB((2*j),(2*k+1), c2);
                        img2.setRGB((2*j+1),(2*k), -1);
                        img2.setRGB((2*j),(2*k), -1);
                        }
                        else if(ws%6==3)
                        {
	                img1.setRGB((2*j+1),(2*k+1), -1);
                        img1.setRGB((2*j),(2*k+1), -1);
                        img1.setRGB((2*j+1),(2*k), c1);
                        img1.setRGB((2*j),(2*k), c1);
                        img2.setRGB((2*j+1),(2*k+1), -1);
                        img2.setRGB((2*j),(2*k+1), -1);
                        img2.setRGB((2*j+1),(2*k), c2);
                        img2.setRGB((2*j),(2*k), c2);
                        }
                        else if(ws%6==4)
                        {
	                img1.setRGB((2*j+1),(2*k+1), -1);
                        img1.setRGB((2*j),(2*k+1), c1);
                        img1.setRGB((2*j+1),(2*k), c1);
                        img1.setRGB((2*j),(2*k), -1);
                        img2.setRGB((2*j+1),(2*k+1), -1);
                        img2.setRGB((2*j),(2*k+1), c2);
                        img2.setRGB((2*j+1),(2*k), c2);
                        img2.setRGB((2*j),(2*k), -1);
                        }
                        else if(ws%6==5)
                        {
	                img1.setRGB((2*j+1),(2*k+1), c1);
                        img1.setRGB((2*j),(2*k+1), -1);
                        img1.setRGB((2*j+1),(2*k), -1);
                        img1.setRGB((2*j),(2*k), c1);
                        img2.setRGB((2*j+1),(2*k+1), c2);
                        img2.setRGB((2*j),(2*k+1), -1);
                        img2.setRGB((2*j+1),(2*k), -1);
                        img2.setRGB((2*j),(2*k), c2);
                        }
                        ws++;
                        }
                        else
                        {
                        c2=im2.getRGB(j,k);
                        c1=im1.getRGB(j,k);
                        if(bs%6==0)
                        {
	                img1.setRGB((2*j+1),(2*k+1), c1);
                        img1.setRGB((2*j),(2*k+1), -16777216);
                        img1.setRGB((2*j+1),(2*k), c1);
                        img1.setRGB((2*j),(2*k), -16777216);
                        img2.setRGB((2*j+1),(2*k+1), -16777216);
                        img2.setRGB((2*j),(2*k+1), c2);
                        img2.setRGB((2*j+1),(2*k), -16777216);
                        img2.setRGB((2*j),(2*k), c2);
                        }
                        else if(bs%6==1)
                        {
	                img1.setRGB((2*j+1),(2*k+1), -16777216);
                        img1.setRGB((2*j),(2*k+1), c1);
                        img1.setRGB((2*j+1),(2*k), -16777216);
                        img1.setRGB((2*j),(2*k), c1);
                        img2.setRGB((2*j+1),(2*k+1), c2);
                        img2.setRGB((2*j),(2*k+1), -16777216);
                        img2.setRGB((2*j+1),(2*k), c2);
                        img2.setRGB((2*j),(2*k), -16777216);
                        }
                        else if(bs%6==2)
                        {
	                img1.setRGB((2*j+1),(2*k+1), -16777216);
                        img1.setRGB((2*j),(2*k+1), -16777216);
                        img1.setRGB((2*j+1),(2*k), c1);
                        img1.setRGB((2*j),(2*k), c1);
                        img2.setRGB((2*j+1),(2*k+1), c2);
                        img2.setRGB((2*j),(2*k+1), c2);
                        img2.setRGB((2*j+1),(2*k), -16777216);
                        img2.setRGB((2*j),(2*k), -16777216);
                        }
                        else if(bs%6==3)
                        {
	                img1.setRGB((2*j+1),(2*k+1), c1);
                        img1.setRGB((2*j),(2*k+1), c1);
                        img1.setRGB((2*j+1),(2*k), -16777216);
                        img1.setRGB((2*j),(2*k), -16777216);
                        img2.setRGB((2*j+1),(2*k+1), -16777216);
                        img2.setRGB((2*j),(2*k+1), -16777216);
                        img2.setRGB((2*j+1),(2*k), c2);
                        img2.setRGB((2*j),(2*k),c2);
                        }
                        else if(bs%6==4)
                        {
	                img1.setRGB((2*j+1),(2*k+1), c1);
                        img1.setRGB((2*j),(2*k+1), -16777216);
                        img1.setRGB((2*j+1),(2*k), -16777216);
                        img1.setRGB((2*j),(2*k), c1);
                        img2.setRGB((2*j+1),(2*k+1), -16777216);
                        img2.setRGB((2*j),(2*k+1), c2);
                        img2.setRGB((2*j+1),(2*k), c2);
                        img2.setRGB((2*j),(2*k), -16777216);
                        }
                        else if(bs%6==5)
                        {
	                img1.setRGB((2*j+1),(2*k+1), -16777216);
                        img1.setRGB((2*j),(2*k+1), c1);
                        img1.setRGB((2*j+1),(2*k), c1);
                        img1.setRGB((2*j),(2*k), -16777216);
                        img2.setRGB((2*j+1),(2*k+1), c2);
                        img2.setRGB((2*j),(2*k+1), -16777216);
                        img2.setRGB((2*j+1),(2*k), -16777216);
                        img2.setRGB((2*j),(2*k), c2);
                        }
                        bs++;
                        }
                        //img.setRGB(j,k, img.getRGB(j,k));
	            }
	        }*/
               File outputfile3 =  new   File ("EVC_br_Share1"+"."+type);
	            ImageIO .write(img1,type,outputfile3);
               File outputfile4 =  new   File ("EVC_br_Share2"+"."+type);
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
                File outputfile5 =  new   File ("EVCFinal"+"."+type);
	            ImageIO .write(img3,type,outputfile5);
	    }

	}

