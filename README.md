
# Chú ý:
Muốn sử dụng xfermode trong view phải gọi bất hoặc tắt tăng tốc phần cứng:
- gọi `setLayerType(LAYER_TYPE_HARDWARE,null)` **(nên dùng)** hoặc `setLayerType(LAYER_TYPE_SOFTWARE,null)` ở init của View

# Các loại Xfermode trong Android 

 1. **SRC:**

	-   Sử dụng pixel của nguồn (hình ảnh được vẽ trước) để tạo ra hình ảnh kết quả.
	-   Hình ảnh đích bị che hoàn toàn bởi hình ảnh nguồn.

 2. **DST:**
	-   Sử dụng pixel của đích (hình ảnh đã được vẽ) để tạo ra hình ảnh kết quả.
	-   Hình ảnh nguồn không ảnh hưởng đến hình ảnh đích.
 3. **SRC_OVER:**

	-   Kết hợp pixel của nguồn và đích theo cách cộng dồn.
	-   Giá trị alpha của pixel được sử dụng để điều chỉnh độ sáng của màu sắc.
 4. **DST_OVER:**

	-   Kết hợp pixel của nguồn và đích theo cách cộng dồn.
	-   Giá trị alpha của pixel đích được sử dụng để điều chỉnh độ sáng của màu sắc.
 5. **SRC_IN:**
	-   Chỉ sử dụng pixel của nguồn nằm trong vùng alpha khác 0 của hình ảnh đích.
	-   Vùng bên ngoài vùng alpha khác 0 của hình ảnh đích sẽ trong suốt.
 6. **DST_IN:**
	-   Chỉ sử dụng pixel của đích nằm trong vùng alpha khác 0 của hình ảnh nguồn.
	-   Vùng bên ngoài vùng alpha khác 0 của hình ảnh nguồn sẽ trong suốt.
	
 7. **SRC_OUT:**
	-   Sử dụng pixel của nguồn nằm ngoài vùng alpha khác 0 của hình ảnh đích.
	-   Vùng alpha khác 0 của hình ảnh đích sẽ trong suốt.
	
 8. **DST_OUT:**

	-   Sử dụng pixel của đích nằm ngoài vùng alpha khác 0 của hình ảnh nguồn.
	-   Vùng alpha khác 0 của hình ảnh nguồn sẽ trong suốt.
	
9. **SRC_ATOP:**

	-   Kết hợp pixel của nguồn và đích theo cách cộng dồn, nhưng chỉ sử dụng pixel của nguồn nằm trong vùng alpha khác 0 của hình ảnh đích.
	-   Vùng bên ngoài vùng alpha khác 0 của hình ảnh đích sẽ trong suốt.

10. **DST_ATOP:**
	-   Kết hợp pixel của nguồn và đích theo cách cộng dồn, nhưng chỉ sử dụng pixel của đích nằm trong vùng alpha khác 0 của hình ảnh nguồn.
	-   Vùng bên ngoài vùng alpha khác 0 của hình ảnh nguồn sẽ trong suốt.

11. **XOR:**
	-   Kết hợp pixel của nguồn và đích theo cách XOR bitwise.
	-   Pixel có giá trị bit khác nhau sẽ có giá trị bit 1, pixel có giá trị bit giống nhau sẽ có giá trị bit 		 0.


12. **CLEAR:**

	-   Xóa tất cả pixel của hình ảnh đích.
	-   Hình ảnh kết quả sẽ trong suốt,
