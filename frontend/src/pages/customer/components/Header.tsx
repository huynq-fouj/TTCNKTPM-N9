import { Link } from "react-router-dom";
import StorageService from "../../../shared/services/StorageService";

export default function Header() {

    const isLogin = StorageService.isLoggedIn();

    return (
        <nav className="navbar navbar-expand-lg bg-white shadow-sm fixed-top">
            <div className="container-fluid">
                <Link className="navbar-brand" to="/">
                    <img src="./cinema.svg" alt="" />
                </Link>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul className="navbar-nav ms-auto me-0">
                        <li className="nav-item">
                            <Link className="nav-link fw-bold" to="/phim">PHIM</Link>
                        </li>
                        {
                            isLogin ? (
                                <li className="nav-item">
                                    <Link className="nav-link fw-bold" to="/thanh-vien">THÀNH VIÊN</Link>
                                </li>
                            ) : (
                                <>
                                    <li className="nav-item">
                                        <Link className="nav-link fw-bold" to="/login">ĐĂNG NHẬP</Link>
                                    </li>
                                    <li className="nav-item">
                                        <Link className="nav-link fw-bold" to="/login#register">ĐĂNG KÝ</Link>
                                    </li>
                                </>
                            )
                        }
                    </ul>
                </div>
            </div>
        </nav>
    )
}