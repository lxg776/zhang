$(function () {

    'use strict';
    var popup = new auiPopup();

    var console = window.console || { log: function () {} };
    var URL = window.URL || window.webkitURL;
    var $image = $('#image');

    var options = {
        aspectRatio: 16 / 16,
        preview: '.img-preview',
        viewMode: 3,
        minContainerWidth:360,
        minContainerHeight:300,
        crop: function (e) {

        }
    };
    var originalImageURL = $image.attr('src');
    var uploadedImageType = 'image/jpeg';
    var uploadedImageURL;





    // Cropper
    $image.on({
        ready: function (e) {
            console.log(e.type);
        },
        cropstart: function (e) {
            console.log(e.type, e.action);
        },
        cropmove: function (e) {
            console.log(e.type, e.action);
        },
        cropend: function (e) {
            console.log(e.type, e.action);
        },
        crop: function (e) {
            console.log(e.type, e.x, e.y, e.width, e.height, e.rotate, e.scaleX, e.scaleY);
        },
        zoom: function (e) {
            console.log(e.type, e.ratio);
        }
    }).cropper(options);


    // Import image
    var $inputImage = $('#inputImage');
    var fileName = "";

    if (URL) {
        $inputImage.change(function () {
            var files = this.files;
            var file;

            if (!$image.data('cropper')) {
                return;
            }

            if (files && files.length) {
                file = files[0];
                fileName = file.name;

                if (/^image\/\w+$/.test(file.type)) {
                    uploadedImageType = file.type;

                    if (uploadedImageURL) {
                        URL.revokeObjectURL(uploadedImageURL);
                    }

                    uploadedImageURL = URL.createObjectURL(file);
                    $image.cropper('destroy').attr('src', uploadedImageURL).cropper(options);
                    $inputImage.val('');
                } else {
                    window.alert('Please choose an image file.');
                }
            }
        });
    } else {
        $inputImage.prop('disabled', true).parent().addClass('disabled');
    }



    // 根据路径获取后缀
    function get_suffix(filename) {
        var pos = filename.lastIndexOf('.');
        var suffix = '';
        if (pos != -1) {
            suffix = filename.substring(pos);
        }
        return suffix;
    }
    // 随机字符串
    function random_string(len) {
        len = len || 32;
        var chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
        var maxPos = chars.length;
        var pwd = '';
        for (var i = 0; i < len; i++) {
            pwd += chars.charAt(Math.floor(Math.random() * maxPos));
        }
        return pwd;
    }





    var uploader = WebUploader.create({
        // 选完文件后，是否自动上传。
        auto: false,
        // swf文件路径
        swf: '${ctx}/webuploader/dist/Uploader.swf',
        // 只允许选择图片文件。
        accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png',
            mimeTypes: 'image/*'
        },
        method:'POST',
    });

    uploader.on('uploadBeforeSend', function (obj, data, headers) {


    });


    uploader.on('uploadSuccess', function(file, json){
        $("#avatar").val( uploader.options.formData.key);

    });

    uploader.onUploadProgress = function (file, percentage) {
            console.log(percentage);
    };

    //保存裁剪
    $("#saveCropper").click(function(){

        var  gOption = {fillColor:"#fff",width:160,height:160};
        var  gsecondOption = {fillColor:"#fff",width:160,height:160};
        var  result = $image.cropper('getCroppedCanvas', gOption,gsecondOption);
        var  base64 = result.toDataURL(uploadedImageType);
        var uploadFile = convertBase64UrlToBlob(base64);

        var oss_policy_url = "http://127.0.0.1:9997/aliyun/oss/ky_policy";
        $.ajax({
            url: oss_policy_url,
            type: "GET",
            dataType: "json", //指定服务器返回的数据类型
            jsonp: "ky",
            success: function (kyData) {
                var suffix = get_suffix(fileName);
                var random_name = random_string();
                uploader.options.server = kyData.action;
                uploader.options.formData.key=kyData.dir + "/" + random_name + suffix;
                uploader.options.formData.policy=kyData.policy;
                uploader.options.formData.signature=kyData.signature;
                uploader.options.formData.action=kyData.action;
                uploader.options.formData.dir=kyData.dir;
                uploader.options.formData.OSSAccessKeyId=kyData.OSSAccessKeyId;
                uploader.options.formData.callback=kyData.callback;

                uploader.addFile(uploadFile);
                uploader.upload();

            }
        });
        $("#headImg").attr("src",base64);
        $image.cropper('destroy');



        popup.hide();
    });



    /**
     * 将以base64的图片url数据转换为Blob
     * @param urlData
     *            用url方式表示的base64图片数据
     */
    function convertBase64UrlToBlob(urlData){

        var bytes=window.atob(urlData.split(',')[1]);        //去掉url的头，并转换为byte

        //处理异常,将ascii码小于0的转换为大于0
        var ab = new ArrayBuffer(bytes.length);
        var ia = new Uint8Array(ab);
        for (var i = 0; i < bytes.length; i++) {
            ia[i] = bytes.charCodeAt(i);
        }

        return new Blob( [ab] , {type : 'image/png'});
    }











});