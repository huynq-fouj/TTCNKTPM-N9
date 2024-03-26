enum EnumGender {
    male = "Nam",
    female = "Nữ",
    other = "Khác"
}

interface SignupRequest {
    fullname: string;
    email: string;
    password: string;
    comfirm: string;
    birthday: Date;
    gender: EnumGender;
    phoneNumber: string;
}