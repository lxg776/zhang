$(function () {



    var console = window.console || { log: function () {} };
    var URL = window.URL || window.webkitURL;
    var uploadedImageType = 'image/jpeg';


    // Import image
    var $inputImage = $('#inputImage');
    var fileName = "";

    if (URL) {
        $inputImage.change(function () {
            var files = this.files;
            var file;

            // if (!$image.data('cropper')) {
            //     return;
            // }

            if (files && files.length) {
                file = files[0];
                fileName = file.name;

                if (/^image\/\w+$/.test(file.type)) {
                    uploadedImageType = file.type;
                    var uploadedImageURL;
                    if (uploadedImageURL) {
                        URL.revokeObjectURL(uploadedImageURL);
                    }

                    uploadedImageURL = URL.createObjectURL(file);
                    $("#headImg").attr('src', uploadedImageURL);
                    $inputImage.val('');
                    uploadFile(file);
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





    var txUploader = WebUploader.create({
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

    txUploader.on('uploadBeforeSend', function (obj, data, headers) {


    });






    txUploader.on('uploadSuccess', function(file, json){
        $("#coverImage").val( txUploader.options.formData.key);
    });

    txUploader.onUploadProgress = function (file, percentage) {
            console.log(percentage);
    };

    function uploadFile(file){
        var oss_policy_url = "/aliyun/oss/policy";
        $.ajax({
            url: oss_policy_url,
            type: "GET",
            success: function (kyData) {
                var suffix = get_suffix(fileName);
                var random_name = random_string();
                txUploader.options.server = kyData.action;
                txUploader.options.formData.key=kyData.dir + "/" + random_name + suffix;
                txUploader.options.formData.policy=kyData.policy;
                txUploader.options.formData.signature=kyData.signature;
                txUploader.options.formData.action=kyData.action;
                txUploader.options.formData.dir=kyData.dir;
                txUploader.options.formData.OSSAccessKeyId=kyData.OSSAccessKeyId;
                txUploader.options.formData.callback=kyData.callback;
                txUploader.addFile(file);
                txUploader.upload();

            }
        });
    }




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