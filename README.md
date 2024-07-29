
# Chú ý:
Muốn sử dụng xfermode trong view phải gọi bất hoặc tắt tăng tốc phần cứng:
- gọi `setLayerType(LAYER_TYPE_HARDWARE,null)` **(nên dùng)** hoặc `setLayerType(LAYER_TYPE_SOFTWARE,null)` ở init của View
- `SRC`: là phần được vẽ áp dụng `paint` có `xfermode`
- `DST`: là tất cả nhưng gì được vẽ trong layer trước phần `SRC`
- Nếu muốn áp dụng nhiều lớp xfermode phải gọi canvas.saveLayer để tác lớp
# Ví dụ bên dưới `SRC là ảnh hình vuông` được vẽ sau và `DST là hình tròn màu đỏ` được vẽ trước
# Các loại Xfermode trong Android 

 1. **SRC:**

	-   Sử dụng pixel của nguồn (hình ảnh được vẽ trước) để tạo ra hình ảnh kết quả.
	-   Hình ảnh đích bị che hoàn toàn bởi hình ảnh nguồn.
        ![SRC](https://github.com/volionamdp/CustomView/blob/Xfermode/image/SRC.jpg)

 2. **DST:**
	-   Sử dụng pixel của đích (hình ảnh đã được vẽ) để tạo ra hình ảnh kết quả.
	-   Hình ảnh nguồn không ảnh hưởng đến hình ảnh đích.
        ![DST](https://github.com/volionamdp/CustomView/blob/Xfermode/image/DST.jpg)

 3. **SRC_OVER:**

	-   Kết hợp pixel của nguồn và đích theo cách cộng dồn.
	-   Giá trị alpha của pixel được sử dụng để điều chỉnh độ sáng của màu sắc.
        ![SRC_OVER](https://github.com/volionamdp/CustomView/blob/Xfermode/image/SRC_OVER.jpg)

 4. **DST_OVER:**

	-   Kết hợp pixel của nguồn và đích theo cách cộng dồn.
	-   Giá trị alpha của pixel đích được sử dụng để điều chỉnh độ sáng của màu sắc.
        ![DST_OVER](https://github.com/volionamdp/CustomView/blob/Xfermode/image/DST_OVER.jpg)

 5. **SRC_IN:**
	-   Chỉ sử dụng pixel của nguồn nằm trong vùng alpha khác 0 của hình ảnh đích.
	-   Vùng bên ngoài vùng alpha khác 0 của hình ảnh đích sẽ trong suốt.
        ![SRC_IN](https://github.com/volionamdp/CustomView/blob/Xfermode/image/SRC_IN.jpg)

 6. **DST_IN:**
	-   Chỉ sử dụng pixel của đích nằm trong vùng alpha khác 0 của hình ảnh nguồn.
	-   Vùng bên ngoài vùng alpha khác 0 của hình ảnh nguồn sẽ trong suốt.
        ![DST_IN](https://github.com/volionamdp/CustomView/blob/Xfermode/image/DST_IN.jpg)

	
 7. **SRC_OUT:**
	-   Sử dụng pixel của nguồn nằm ngoài vùng alpha khác 0 của hình ảnh đích.
	-   Vùng alpha khác 0 của hình ảnh đích sẽ trong suốt.
        ![SRC_OUT](https://github.com/volionamdp/CustomView/blob/Xfermode/image/SRC_OUT.jpg)

	
 8. **DST_OUT:**

	-   Sử dụng pixel của đích nằm ngoài vùng alpha khác 0 của hình ảnh nguồn.
	-   Vùng alpha khác 0 của hình ảnh nguồn sẽ trong suốt.
        ![DST_OUT](https://github.com/volionamdp/CustomView/blob/Xfermode/image/DST_OUT.jpg)

	
9. **SRC_ATOP:**

	-   Kết hợp pixel của nguồn và đích theo cách cộng dồn, nhưng chỉ sử dụng pixel của nguồn nằm trong vùng alpha khác 0 của hình ảnh đích.
	-   Vùng bên ngoài vùng alpha khác 0 của hình ảnh đích sẽ trong suốt.
        ![SRC_ATOP](https://github.com/volionamdp/CustomView/blob/Xfermode/image/SRC_ATOP.jpg)


10. **DST_ATOP:**
	-   Kết hợp pixel của nguồn và đích theo cách cộng dồn, nhưng chỉ sử dụng pixel của đích nằm trong vùng alpha khác 0 của hình ảnh nguồn.
	-   Vùng bên ngoài vùng alpha khác 0 của hình ảnh nguồn sẽ trong suốt.
        ![DST_ATOP](https://github.com/volionamdp/CustomView/blob/Xfermode/image/DST_ATOP.jpg)


11. **XOR:**
	-   Kết hợp pixel của nguồn và đích theo cách XOR bitwise.
	-   Pixel có giá trị bit khác nhau sẽ có giá trị bit 1, pixel có giá trị bit giống nhau sẽ có giá trị bit 		 0.

        ![XOR](https://github.com/volionamdp/CustomView/blob/Xfermode/image/XOR.jpg)

12. **CLEAR:**

	-   Xóa tất cả pixel của hình ảnh đích.
	-   Hình ảnh kết quả sẽ trong suốt,
        ![CLEAR](https://github.com/volionamdp/CustomView/blob/Xfermode/image/CLEAR.jpg)
