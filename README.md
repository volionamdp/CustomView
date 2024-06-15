Lớp `Paint` trong Android cung cấp một loạt các phương thức để tùy chỉnh cách vẽ và trang trí các hình ảnh trên `Canvas`:

### Các phương thức của lớp `Paint` hay sử dụng:

1. **setColor(int color)**
   - Đặt màu sắc cho `Paint`.
   - `color`: Màu sắc được xác định bằng `int`, ví dụ `Color.RED`.

2. **setARGB(int a, int r, int g, int b)**
   - Đặt màu sắc cho `Paint` dựa trên các giá trị ARGB.
   - `a`, `r`, `g`, `b`: Các thành phần Alpha, Red, Green, Blue của màu.

3. **setAlpha(int alpha)**
   - Đặt độ mờ của `Paint`.
   - `alpha`: Giá trị từ 0 (hoàn toàn trong suốt) đến 255 (hoàn toàn không trong suốt).
   - lưu ý: setAlpha phải gọi sau setColor mới có tác dụng

4. **setAntiAlias(boolean isAntiAlias)**
   - Đặt chế độ làm mịn cho `Paint`.
   - `isAntiAlias`: `true` để bật chế độ làm mịn (AntiAlias), giúp các đường vẽ mượt mà hơn.

5. **setStyle(Paint.Style style)**
   - Đặt kiểu vẽ cho `Paint`.
   - `style`: Kiểu vẽ có thể là `Paint.Style.FILL` (đổ màu), `Paint.Style.STROKE` (nét đường) hoặc `Paint.Style.FILL_AND_STROKE` (đổ màu và vẽ nét đường).
   - lưu ý: FILL_AND_STROKE vẫn cùng màu sắc chứ không phải riêng biệt

6. **setStrokeWidth(float width)**
   - Đặt độ dày của nét vẽ khi sử dụng kiểu `Paint.Style.STROKE`.
   - `width`: Độ dày của nét vẽ, tính bằng pixel.

7. **setStrokeCap(Paint.Cap cap)**
   - Đặt loại nét điểm đầu và cuối (path,line...) khi dùng `Paint` .
   - `cap`: Loại nét đầu có thể là `Paint.Cap.BUTT`, `Paint.Cap.ROUND`, hoặc `Paint.Cap.SQUARE`.

8. **setStrokeJoin(Paint.Join join)**
   - Đặt loại giao điểm nối giữa các đoạn đường khi có gấp khúc.
   - `join`: Loại giao điểm nối có thể là `Paint.Join.MITER`, `Paint.Join.ROUND`, hoặc `Paint.Join.BEVEL`.

9. **setShader(Shader shader)**
   - Đặt `Shader` cho `Paint` để điều chỉnh màu sắc hoặc mẫu nền của hình vẽ.
   - `shader`: Đối tượng `Shader` để điều chỉnh màu sắc hoặc mẫu nền .
   - vd: hình hoặc nét vẽ muốn có gradient thì dùng LinearGradient,RadialGradient,RadialGradient. Nếu hình hoặc nét vẽ khi vẽ ra một hình khác thì dùng BitmapShader (các hiệu ứng Kính lúp phóng to nét vẽ có thể dùng cái này) 

10. **setXfermode(Xfermode xfermode)**
    - Đặt `Xfermode` cho `Paint` để điều chỉnh chế độ vẽ và blend các hình vẽ trên `Canvas`.

11. **setMaskFilter(MaskFilter maskfilter)**
    - Đặt `MaskFilter` cho `Paint` để điều chỉnh hiệu ứng lọc ánh sáng khi vẽ.

12. **setPathEffect(PathEffect effect)**
    - Đặt `PathEffect` cho `Paint` để điều chỉnh đường nét khi vẽ các đường cong.
      
### Text:

13. **measureText(String text)**
    - Đo độ dài của text khi vẽ lên View.
    - `text`: Chuỗi văn bản cần đo.    

14. **setTextSize(float textSize)**
    - Đặt kích thước chữ cho văn bản khi sử dụng `Canvas.drawText()`.
    - `textSize`: Kích thước của chữ, tính bằng pixel.

15. **setTextAlign(Paint.Align align)**
    - Đặt căn lề cho văn bản khi sử dụng `Canvas.drawText()`.
    - `align`: Căn lề có thể là `Paint.Align.LEFT`, `Paint.Align.CENTER`, hoặc `Paint.Align.RIGHT`.

16. **setTypeface(Typeface typeface)**
    - Đặt kiểu chữ (Typeface) cho văn bản khi sử dụng `Canvas.drawText()`.
    - `typeface`: Đối tượng `Typeface` để sử dụng cho văn bản.

17. **setTextScaleX(float scaleX)**
    - Đặt tỉ lệ co giãn của văn bản khi sử dụng `Canvas.drawText()`.
    - `scaleX`: Tỉ lệ co giãn, ví dụ `1.0f` là bình thường, `0.5f` là thu nhỏ lại nửa.

18. **setFakeBoldText(boolean fakeBoldText)**
    - Đặt chế độ văn bản đậm giả (fake bold text) khi sử dụng `Canvas.drawText()`.
    - `fakeBoldText`: `true` để sử dụng văn bản đậm giả.

19. **setTextSkewX(float skewX)**
    - Đặt góc nghiêng của văn bản khi sử dụng `Canvas.drawText()`.
    - `skewX`: Góc nghiêng, tính bằng độ.

20. **setUnderlineText(boolean underlineText)**
    - Đặt chế độ gạch chân văn bản (underline text) cho `Paint`.

21. **setStrikeThruText(boolean strikeThruText)**
    - Đặt chế độ gạch ngang văn bản (strike-through text) cho `Paint`.
