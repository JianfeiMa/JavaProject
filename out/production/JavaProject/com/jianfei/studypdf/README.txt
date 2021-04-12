<!-- 依赖 -->
<dependency>
    <groupId>com.google.zxing</groupId>
    <artifactId>core</artifactId>
    <version>3.4.1</version>
</dependency>

/** 生成QRCode */
public class EncodingUtils {
    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;

    public static void test() {
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode("ABCabc123-88", BarcodeFormat.QR_CODE, 60, 60);
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            java.awt.image.BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x ++) {
                for (int y = 0; y < height; y ++) {
                    bufferedImage.setRGB(x, y, bitMatrix.get(x, y) ? BLACK : WHITE);
                }
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", new File("D:\\codeImg\\test.png"));
            byte[] bytes = byteArrayOutputStream.toByteArray();
        } catch (com.google.zxing.WriterException writerException) {
            writerException.printStackTrace();
        } catch (java.io.IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
